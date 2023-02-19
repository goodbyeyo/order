package com.present.order.infrastructure.order;

import com.present.order.domain.order.Order;
import com.present.order.domain.order.OrderCommand;
import com.present.order.domain.order.OrderItemSeriesFactory;
import com.present.order.domain.order.item.OrderItem;

import java.util.List;

public class CustomOrderItemSeriesFactory implements OrderItemSeriesFactory {

    @Override
    public List<OrderItem> store(Order order, OrderCommand.RegisterOrder requestOrder) {
        // 잘 만든 factory 로직 구현
        return null;
    }
}
