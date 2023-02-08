package com.present.order.domain.order.payment.validator;

import com.present.order.domain.order.Order;
import com.present.order.domain.order.OrderCommand;

public interface PaymentValidator {
    void validate(Order order, OrderCommand.PaymentRequest paymentRequest);
}
