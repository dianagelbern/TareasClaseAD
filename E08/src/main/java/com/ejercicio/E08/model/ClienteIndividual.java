package com.ejercicio.E08.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter
@SuperBuilder
@NoArgsConstructor @AllArgsConstructor
public class ClienteIndividual extends Cliente implements Serializable {

    private String email;

    public ClienteIndividual(String nombre, String direccion, String codigoPostal, int codCliente, String telefono, String email) {
        super(nombre, direccion, codigoPostal, codCliente, telefono);
        this.email = email;
    }
}
