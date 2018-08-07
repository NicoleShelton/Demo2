package com.example.demo2.model.internal.response;

public class GetItemResponse {
    public static class Item {
        private Long id;
        private String csn;
        private String description;

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

    }

    private Item item;

    public Item getItem() {
        return item;
    }

    public GetItemResponse setItem(Item item) {
        this.item = item;
        return this;
    }
}
