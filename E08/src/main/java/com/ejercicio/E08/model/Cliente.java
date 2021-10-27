package com.ejercicio.E08.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

//Justificación:
/*
Según a mi entender, ya que existen dos tipos de clientes (corporativo e individual) y ambos engloban los
tipos de clientes que se pueden tener no es necesario hacer que cliente per se genere una tabla para si misma

 */
@MappedSuperclass
@Getter @Setter
@SuperBuilder
public abstract class Cliente implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String direccion;
    private String codigoPostal;

}
