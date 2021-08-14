package com.platzi.market.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public @Data
class  comprasProductoPK implements Serializable  {

    @Column(name="id_compra")
    private Integer idCompra;

    @Column(name="id_producto")
    private Integer idProducto;

}
