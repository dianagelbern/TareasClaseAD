package com.ejercicio.E08.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Justificación:
/*
Ya que tiene una clase que depende de ella (pedido) no puede ser abstracta ya que no nos generaría
tabla la cual necesitamos

 */
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@SuperBuilder
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String direccion;
    private String codigoPostal;
    private int codCliente;
    private String telefono;

    @Builder.Default
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();


    public Cliente(String nombre, String direccion, String codigoPostal, int codCliente, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.codCliente = codCliente;
        this.telefono = telefono;
    }


}
