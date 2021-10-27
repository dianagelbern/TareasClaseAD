package com.ejercicio.E08.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
@Getter @Setter
public class Pedido implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private int numPedido;



}
