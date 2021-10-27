package com.ejercicio.E08.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@SuperBuilder
public class ClienteCorporativo extends Cliente implements Serializable {

    private int numReferencia;
    private String nombreCompania;
    private String pais;

    @ManyToOne
    @JoinColumn(name = "empleado")
    private Empleado empleado;

    public ClienteCorporativo(String nombre, String direccion, String codigoPostal, int codCliente, String telefono, int numReferencia, String nombreCompania, String pais) {
        super(nombre, direccion, codigoPostal, codCliente, telefono);
        this.numReferencia = numReferencia;
        this.nombreCompania = nombreCompania;
        this.pais = pais;
    }





    public void addEmpleado(Empleado e){
        this.empleado = e;
        e.getClienteCorporativos().add(this);
    }

    public void removeEmpleado(Empleado e){
        e.getClienteCorporativos().remove(this);
        this.empleado = null;
    }
}
