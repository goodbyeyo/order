package com.present.order.domain.order.gift;

import com.present.order.domain.order.OrderCommand;

public interface GiftOrderService {
    void paymentOrder(OrderCommand.PaymentRequest paymentRequest);
}
