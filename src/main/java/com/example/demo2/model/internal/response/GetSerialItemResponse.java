package com.example.demo2.model.internal.response;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GetSerialItemResponse{
    private SerialItem serialItem;

    public SerialItem getSerialItem() {
        return serialItem;
    }

    public GetSerialItemResponse setSerialItem(SerialItem serialItem) {
        this.serialItem = serialItem;
        return this;
    }

    public static class SerialItem{
        private Long serialItemId;
        private String serialNumber;
        private Long itemId;
        private String csn;
        private String description;
        private User createUser;
        //privateUserexpireUser;

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

        public Long getItemId() {
            return itemId;
        }

        public SerialItem setItemId(Long itemId) {
            this.itemId = itemId;
            return this;
        }

        public String getCsn() {
            return csn;
        }

        public SerialItem setCsn(String csn) {
            this.csn = csn;
            return this;
        }

        public String getDescription() {
            return description;
        }

        public SerialItem setDescription(String description) {
            this.description = description;
            return this;
        }

        public User getCreateUser() {
            return createUser;
        }

        public SerialItem setCreateUser(User createUser) {
            this.createUser = createUser;
            return this;
        }


        //publicUsergetExpireUser(){
        //returnexpireUser;
        //}
        //
        //publicItemsetExpireUser(UserexpireUser){
        //this.expireUser=expireUser;
        //returnthis;
        //}
        }

        public static class User{
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

}
