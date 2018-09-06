package com.example.demo2.model.internal;

import java.util.Date;

public class Item {

    private Long id;
    private String csn;
    private String description;
    private Long createUserId;
    private Date createDate;
    private Long expireUserId;
    private Date expireDate;

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
}
