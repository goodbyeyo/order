package com.present.order.domain.order.payment.validator;

import com.present.order.common.exception.InvalidParamException;
import com.present.order.domain.order.Order;
import com.present.order.domain.order.OrderCommand;
import com.present.order.domain.order.payment.PayMethod;

public class FdsPaymentValidator implements PaymentValidator {

        @Override
        public void validate(Order order, OrderCommand.PaymentRequest paymentRequest) {
            if (paymentRequest.getPayMethod() == PayMethod.STOLEN_CARD)
                throw new InvalidParamException("이미 결제완료된 주문입니다");
        }
}
