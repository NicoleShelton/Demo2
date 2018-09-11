package com.example.demo2.model.internal;

public class SerialItem{
    private Long serialItemId;
    private String serialNumber;
    private Long Id;
    private String Csn;
    private String Description;
    private Long CreateUserId;

    public Long getSerialItemId() {
        return serialItemId;
    }

    public SerialItem setSerialItemId(Long serialItemId) {
        this.serialItemId = serialItemId;
        return this;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public SerialItem setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public Long getId() {
        return Id;
    }

    public SerialItem setId(Long id) {
        Id = id;
        return this;
    }

    public String getCsn() {
        return Csn;
    }

    public SerialItem setCsn(String csn) {
        Csn = csn;
        return this;
    }

    public String getDescription() {
        return Description;
    }

    public SerialItem setDescription(String description) {
        Description = description;
        return this;
    }

    public Long getCreateUserId() {
        return CreateUserId;
    }

    public SerialItem setCreateUserId(Long createUserId) {
        CreateUserId = createUserId;
        return this;
    }
}
