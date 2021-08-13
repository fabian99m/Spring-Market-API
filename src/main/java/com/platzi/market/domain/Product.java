package com.platzi.market.domain;

import lombok.Data;

public @Data
class Product {
    private int productId;
    private String name;
    private int categoryId;
    private double price;
    private int stock;
    private boolean active;
    private Category category;
}
