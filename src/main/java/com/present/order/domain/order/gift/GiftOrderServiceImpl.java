package com.present.order.domain.order.gift;

import com.present.order.common.exception.IllegalStatusException;
import com.present.order.domain.order.Order;
import com.present.order.domain.order.OrderCommand;
import com.present.order.domain.order.OrderReader;
import com.present.order.domain.order.payment.PaymentProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class GiftOrderServiceImpl implements GiftOrderService {
    private final OrderReader orderReader;
    private final PaymentProcessor paymentProcessor;
    private final GiftMessageChannelSender giftMessageChannelSender;

    @Override
    @Transactional
    public void paymentOrder(OrderCommand.PaymentRequest paymentRequest) {
        log.info("GiftOrderService.paymentOrder request = {}", paymentRequest);
        var order = orderReader.getOrder(paymentRequest.getOrderToken());

        // 아래 로직을 추가하면, paymentProcessor.pay 실행 이후의 보상 트랜잭션 발생을 막을 수 있다
        if (order.getStatus() != Order.Status.INIT) throw new IllegalStatusException();

        paymentProcessor.pay(order, paymentRequest);
        order.orderComplete();

        // 결제가 완료되었는데, but orderComplete 실행되지 않은 경우에는 보상 트랜잭션을 실행한다
//        try{
//            paymentProcessor.pay(order, paymentRequest);
//            order.orderComplete();
//        } catch (Exception e) {
//            paymentProcessor.refund(order);
//        }

        giftMessageChannelSender.paymentComplete(new GiftPaymentCompleteMessage(order.getOrderToken()));
    }
}
