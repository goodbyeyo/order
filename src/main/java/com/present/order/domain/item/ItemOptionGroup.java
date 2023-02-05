package com.present.order.domain.item;

import com.present.order.domain.AbstractEntity;

import javax.persistence.*;

public class ItemOptionGroup extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    
    private Integer ordering;
    private String itemOptionGroupName;

}
