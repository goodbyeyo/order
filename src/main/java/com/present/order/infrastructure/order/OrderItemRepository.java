package com.present.order.infrastructure.order;

import com.present.order.domain.order.item.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
