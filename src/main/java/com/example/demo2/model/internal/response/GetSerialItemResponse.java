package com.example.demo2.model.internal.response;

import com.example.demo2.model.internal.Item;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GetSerialItemResponse {
    public static class Item {
        private Long serialItemId;
        private String serialNumber;
        private Long itemId;
        private String csn;
        private String description;
        private User createUser;
        private User expireUser;

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

        public Long getItemId() {
            return itemId;
        }

        public Item setItemId(Long itemId) {
            this.itemId = itemId;
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

        public User getCreateUser() {
            return createUser;
        }

        public Item setCreateUser(User createUser) {
            this.createUser = createUser;
            return this;
        }

        public User getExpireUser() {
            return expireUser;
        }

        public Item setExpireUser(User expireUser) {
            this.expireUser = expireUser;
            return this;
        }
    }

    public static class User {
        private Long id;
        private String fistName;
        private String lastName;

        public Long getId() {
            return id;
        }

        public User setId(Long id) {
            this.id = id;
            return this;
        }

        public String getFistName() {
            return fistName;
        }

        public User setFistName(String fistName) {
            this.fistName = fistName;
            return this;
        }

        public String getLastName() {
            return lastName;
        }

        public User setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
    }

    private Item item;

    public Item getItem() {
        return item;
    }

    public GetSerialItemResponse setItem(Item item) {
        this.item = item;
        return this;
    }
}
