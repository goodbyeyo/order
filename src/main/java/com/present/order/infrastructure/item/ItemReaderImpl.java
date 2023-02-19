package com.present.order.infrastructure.item;

import com.present.order.common.exception.EntityNotFoundException;
import com.present.order.domain.item.Item;
import com.present.order.domain.item.ItemInfo;
import com.present.order.domain.item.ItemReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class ItemReaderImpl implements ItemReader {
    private final ItemRepository itemRepository;

    @Override
    public Item getItemBy(String itemToken) {
        return itemRepository.findByItemToken(itemToken)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<ItemInfo.ItemOptionGroupInfo> getItemOptionSeries(Item item) {
        // Aggregate Root : Item <ROOT> -> ItemOptionGroup -> ItemOption
        var itemOptionGroupList = item.getItemOptionGroupList();
        return itemOptionGroupList.stream()
                .map(itemOptionGroup -> {
                    var itemOptionList = itemOptionGroup.getItemOptionList();
                    var itemOptionInfoList = itemOptionList.stream()
                            .map(ItemInfo.ItemOptionInfo::new)
                            .collect(Collectors.toList());

                    return new ItemInfo.ItemOptionGroupInfo(itemOptionGroup, itemOptionInfoList);
                }).collect(Collectors.toList());
    }
}
