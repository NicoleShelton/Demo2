package com.example.demo2.model.internal.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CreateItemResponse {
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
    private Boolean success;
    private final List<String> errors = new ArrayList<>();

    public Item getItem() {
        return item;
    }

    public CreateItemResponse setItem(Item item) {
        this.item = item;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public CreateItemResponse setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public List<String> getErrors() {
        return errors;
    }
}
