package com.ejercicio.E08.model;

import lombok.*;

import javax.persistence.*;
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

    //He decidido darle esta asociación bidireccional ya que me parece que
    //es conveniente que cuando se traigan los datos de un pedido vengan también los de su cliente
    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    public void addCliente(Cliente c){
        this.cliente = c;
        c.getPedidos().add(this);
    }

    public void removeCliente(Cliente c){
        c.getPedidos().remove(this);
        this.cliente = null;
    }
}
