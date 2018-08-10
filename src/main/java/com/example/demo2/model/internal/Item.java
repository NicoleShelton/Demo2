package com.example.demo2.model.internal;

import com.example.demo2.model.internal.response.GetSerialItemResponse;

import java.util.Date;

public class Item {

    private Long id;
    private String csn;
    private String description;
    private Long createUserId;
    private Date createDate;

    public Long getId() {
        return id;
    }

    public Item setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCsn() {
        return csn;
    }

    public Item setCsn(String csn) {
        this.csn = csn;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public Item setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Item setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    private Long expireUserId;
    private Date expireDate;

    public Long getExpireUserId() {
        return expireUserId;
    }

    public Item setExpireUserId(Long expireUserId) {
        this.expireUserId = expireUserId;
        return this;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public Item setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    private Long serialItemId;
    private String serialNumber;

    public Long getSerialItemId() {
        return serialItemId;
    }

    public Item setSerialItemId(Long serialItemId) {
        this.serialItemId = serialItemId;
        return this;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Item setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }
}
