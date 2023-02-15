package com.present.order.infrastructure.item;

import com.present.order.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByItemToken(String itemToken);
}
