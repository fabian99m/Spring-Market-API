package com.platzi.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private String id;

    private String nombre;

    private String apellidos;

    private Long celular;

    private String direccion;

    @Column(name = "correo_electronico")
    private String email;

    // relaciones

    @OneToMany
    @JoinColumn(name="cliente")
    private List<Compra> compras;

}
