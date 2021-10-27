package com.ejercicio.E08.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Empleado implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private int numEmpleado;

    @Builder.Default
    @OneToMany(mappedBy = "empleado")
    private List<ClienteCorporativo> clienteCorporativos = new ArrayList<>();


    public Empleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }
}
