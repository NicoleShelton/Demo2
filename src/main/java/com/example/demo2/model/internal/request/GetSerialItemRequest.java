package com.example.demo2.model.internal.request;

public class GetSerialItemRequest {
    private String serialNumber;

    public String getSerialNumber() {
        return serialNumber;
    }

    public GetSerialItemRequest setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }
}
