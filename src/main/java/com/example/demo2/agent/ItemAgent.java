package com.example.demo2.agent;

import com.example.demo2.model.internal.request.CreateItemRequest;
import com.example.demo2.model.internal.request.GetItemRequest;
import com.example.demo2.model.internal.response.CreateItemResponse;
import com.example.demo2.model.internal.response.GetItemResponse;

public interface ItemAgent {
    GetItemResponse getItem(GetItemRequest request);
    CreateItemResponse createItem(CreateItemRequest request);
}
