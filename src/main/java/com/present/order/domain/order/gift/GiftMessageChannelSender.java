package com.present.order.domain.order.gift;

public interface GiftMessageChannelSender {
    void paymentComplete(GiftPaymentCompleteMessage message);
}
