package com.present.order.domain.order.payment.validator;

import com.present.order.common.exception.InvalidParamException;
import com.present.order.domain.order.Order;
import com.present.order.domain.order.OrderCommand;
import org.springframework.stereotype.Component;

@org.springframework.core.annotation.Order(value = 3)
@Component
public class PayStatusValidator implements PaymentValidator {

    @Override
    public void validate(Order order, OrderCommand.PaymentRequest paymentRequest) {
        if (order.isAlreadyPaymentComplete()) throw new InvalidParamException("이미 결제완료된 주문입니다");
    }
}