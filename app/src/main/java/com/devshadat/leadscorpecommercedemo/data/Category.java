package com.devshadat.leadscorpecommercedemo.data;

public class Category {

    private String name;
    private int quantity;

    public Category(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
