package com.present.order.infrastructure.payment;

import com.present.order.domain.order.OrderCommand;
import com.present.order.domain.order.payment.PayMethod;

public interface PaymentApiCaller {
    boolean support(PayMethod payMethod);
    void pay(OrderCommand.PaymentRequest request);
}