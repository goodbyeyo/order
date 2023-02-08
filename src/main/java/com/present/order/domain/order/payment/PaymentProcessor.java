package com.present.order.domain.order.payment;

import com.present.order.domain.order.Order;
import com.present.order.domain.order.OrderCommand;

public interface PaymentProcessor {
    void pay(Order order, OrderCommand.PaymentRequest request);
}
