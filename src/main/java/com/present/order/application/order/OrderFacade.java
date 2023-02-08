package com.present.order.application.order;

import com.present.order.domain.notification.NotificationService;
import com.present.order.domain.order.OrderCommand;
import com.present.order.domain.order.OrderInfo;
import com.present.order.domain.order.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderFacade {
    private final OrderService orderService;
    private final NotificationService notificationService;

    // 1. 결제 직후 문자 발송을 facade 에 넣을지 domain 에 넣을지 상황에 따라 다르다
    // 2. 결제 직후 문자 발송이 필수라면 도메인에 넣고 아니면 넣지 않는다. 보통은 필수가 아니다
    // 3. 도메인은 tx 로 묶이기 때문에 tx 로 묶는다는것은 무조건 실행되어야 한다는것을 의미 -> 도메인 지식
    // 4. 안묶인다는것은 핵심 도메인 지식이 아니라는것을 의미

    public String registerOrder(OrderCommand.RegisterOrder registerOrder) {
        var orderToken = orderService.registerOrder(registerOrder);
        notificationService.sendKakao("ORDER_COMPLETE", "content");
        return orderToken;
    }

    public OrderInfo.Main retrieveOrder(String orderToken) {
        return orderService.retrieveOrder(orderToken);
    }

    public void paymentOrder(OrderCommand.PaymentRequest paymentRequest) {
        orderService.paymentOrder(paymentRequest);
        notificationService.sendKakao(null, null);
    }
}
