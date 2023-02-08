package com.present.order.domain.order;

public interface OrderReader {
    Order getOrder(String orderToken);
}
