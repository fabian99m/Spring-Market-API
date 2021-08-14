package com.platzi.market.domain;

import lombok.Data;

public @Data
class PurchaseItem {

    private  int idProduct;
    private int quantity;
    private Double total;
    private boolean active;

}
