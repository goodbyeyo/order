package com.present.order.domain.order.payment.validator;

import com.present.order.common.exception.InvalidParamException;
import com.present.order.domain.order.Order;
import com.present.order.domain.order.OrderCommand;
import org.springframework.stereotype.Component;

@org.springframework.core.annotation.Order(value = 2)
@Component
public class PayMethodValidator implements PaymentValidator {

    @Override
    public void validate(Order order, OrderCommand.PaymentRequest paymentRequest) {
        if (!order.getPayMethod().equals(paymentRequest.getPayMethod().name())) {
            throw new InvalidParamException("주문 과정에서의 결제수단이 다릅니다.");
        }
    }
}
