package com.present.order.domain.order.payment;

import com.present.order.domain.order.OrderCommand;

public interface PaymentProcessor {
    void pay(OrderCommand.PaymentRequest request);
}
