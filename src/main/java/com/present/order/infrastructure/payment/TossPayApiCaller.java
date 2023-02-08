package com.present.order.infrastructure.payment;

import com.present.order.domain.order.OrderCommand;
import com.present.order.domain.order.payment.PayMethod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TossPayApiCaller implements PaymentApiCaller {

    @Override
    public boolean support(PayMethod payMethod) {
        return PayMethod.TOSS_PAY == payMethod;
    }

    @Override
    public void pay(OrderCommand.PaymentRequest request) {
        // TODO - 구현
        // 1. adapter 통해 toss pay api 호출 (tossPay 주문금액 payAmount <- request.getPayAmount())
        // 2. toss pay api 호출 결과를 통해 결제 성공 여부 판단
        // 3. 결제 성공 시, 결제 정보를 저장
    }
}
