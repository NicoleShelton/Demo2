package com.example.demo2.model.internal.request;

public class CreateItemRequest {
    private String csn;
    private String description;
    private Long userId;

    public String getCsn() {
        return csn;
    }

    public CreateItemRequest setCsn(String csn) {
        this.csn = csn;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CreateItemRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public CreateItemRequest setUserId(Long userId) {
        this.userId = userId;
        return this;
    }
}
