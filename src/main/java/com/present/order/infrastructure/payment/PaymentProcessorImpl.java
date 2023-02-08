package com.present.order.infrastructure.payment;

import com.present.order.common.exception.InvalidParamException;
import com.present.order.domain.order.Order;
import com.present.order.domain.order.OrderCommand;
import com.present.order.domain.order.payment.PaymentProcessor;
import com.present.order.domain.order.payment.validator.PaymentValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentProcessorImpl implements PaymentProcessor {
    private final List<PaymentValidator> paymentValidatorList;
    // 결제 처리 수단의 객체군, 복수의 Bean 주입 될 수 있음
    private final List<PaymentApiCaller> paymentApiCallerList;

    @Override
    public void pay(Order order, OrderCommand.PaymentRequest paymentRequest) {
        paymentValidatorList.forEach(paymentValidator -> paymentValidator.validate(order, paymentRequest));
        PaymentApiCaller payApiCaller = routingApiCaller(paymentRequest);
        payApiCaller.pay(paymentRequest);
    }

    // 결제 처리 수단의 객체군 중, 해당 결제 수단을 지원하는 객체를 찾아서 반환
    private PaymentApiCaller routingApiCaller(OrderCommand.PaymentRequest request) {
        return paymentApiCallerList.stream()
                .filter(paymentApiCaller -> paymentApiCaller.support(request.getPayMethod()))
                .findFirst()
                .orElseThrow(InvalidParamException::new);
    }
}
