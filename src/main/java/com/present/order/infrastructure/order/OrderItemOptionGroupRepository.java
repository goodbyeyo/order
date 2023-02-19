package com.present.order.infrastructure.order;

import com.present.order.domain.order.item.OrderItemOptionGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemOptionGroupRepository extends JpaRepository<OrderItemOptionGroup, Long> {
}
