package com.platzi.market.persistence.entity;

import lombok.Data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="categorias")
public @Data
class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria")

    private Integer idCategoria;
    private String descripcion;
    private Boolean estado;

    //relaciones

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

}
