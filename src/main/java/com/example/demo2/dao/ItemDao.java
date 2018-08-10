package com.example.demo2.dao;

import com.example.demo2.model.internal.Item;

public interface ItemDao {
    Item getItemById(Long id);

    Long getItemIdNextValue();

    boolean createItem(Long itemId, String csn, String description, Long createUserId);

    Item getSerialItemById(Long SerialNumber);
}
