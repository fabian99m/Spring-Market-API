package com.platzi.market.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "compras_productos")
public @Data
class comprasProducto {

    @EmbeddedId
    private comprasProductoPK id;
    private Integer cantidad;
    private Double total;
    private Boolean estado;

    // relaciones

    @ManyToOne
    @MapsId("idCompra")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

}
