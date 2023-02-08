package com.present.order.domain.order;

import com.present.order.domain.order.item.OrderItem;
import com.present.order.domain.order.item.OrderItemOption;
import com.present.order.domain.order.item.OrderItemOptionGroup;

public interface OrderStore {
    Order store(Order order);
    OrderItem store(OrderItem orderItem);
    OrderItemOptionGroup store(OrderItemOptionGroup orderItemOptionGroup);
    OrderItemOption store(OrderItemOption orderItemOption);
}

