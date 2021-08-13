package com.platzi.market.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


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
