package com.platzi.market.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "productos")
public @Data class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    private String nombre;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String  codigoBarras;

    @Column(name = "precio_venta")
    private float precioVenta;

    @Column(name = "cantidad_Stock")
    private Integer cantidadStock;

    private Boolean estado;

    // relaciones

    @ManyToOne
    @JoinColumn(name="id_categoria", insertable = false,updatable = false)
    private Categoria categoria;
}
