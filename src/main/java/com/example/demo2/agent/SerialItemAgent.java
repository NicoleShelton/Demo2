package com.example.demo2.agent;

import com.example.demo2.model.internal.request.GetSerialItemRequest;
import com.example.demo2.model.internal.response.GetSerialItemResponse;

public interface SerialItemAgent{
    GetSerialItemResponse getSerialItem(GetSerialItemRequest request);
}
