package com.platzi.market.domain;

import lombok.Data;

public @Data
class Category {
    private int categoryId;
    private String category;
    private boolean active;
}
