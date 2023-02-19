package com.present.order.infrastructure.item;

import com.present.order.domain.item.Item;
import com.present.order.domain.item.ItemCommand;
import com.present.order.domain.item.ItemOptionSeriesFactory;
import com.present.order.domain.item.option.ItemOptionStore;
import com.present.order.domain.item.optiongroup.ItemOptionGroup;
import com.present.order.domain.item.optiongroup.ItemOptionGroupStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class ItemOptionSeriesFactoryImpl implements ItemOptionSeriesFactory {
    private final ItemOptionGroupStore itemOptionGroupStore;
    private final ItemOptionStore itemOptionStore;

    @Override
    public List<ItemOptionGroup> store(ItemCommand.RegisterItemRequest command, Item item) {
        var itemOptionGroupRequestList = command.getItemOptionGroupRequestList();
        if (CollectionUtils.isEmpty(itemOptionGroupRequestList)) return Collections.emptyList();

        return itemOptionGroupRequestList.stream()
                .map(requestItemOptionGroup -> {    // ex) 색상, 사이즈
                    // itemOptionGroup store
                    var initItemOptionGroup = requestItemOptionGroup.toEntity(item);
                    var itemOptionGroup = itemOptionGroupStore.store(initItemOptionGroup);

                    // itemOption store
                    requestItemOptionGroup.getItemOptionRequestList().forEach(requestItemOption -> { // ex) 빨강, 파랑, 노랑, S, M, L
                        var initItemOption = requestItemOption.toEntity(itemOptionGroup);
                        itemOptionStore.store(initItemOption);
                    });

                    return itemOptionGroup;
                }).collect(Collectors.toList());
    }
}
