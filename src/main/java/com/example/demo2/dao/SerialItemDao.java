package com.example.demo2.dao;

import com.example.demo2.model.internal.SerialItem;

public interface SerialItemDao{
    SerialItem getSerialItemBySerialNum(Long SerialNumber);
}
