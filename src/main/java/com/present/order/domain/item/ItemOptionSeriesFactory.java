package com.present.order.domain.item;

import com.present.order.domain.item.optiongroup.ItemOptionGroup;

import java.util.List;

public interface ItemOptionSeriesFactory {
    List<ItemOptionGroup> store(ItemCommand.RegisterItemRequest request, Item item);
}
