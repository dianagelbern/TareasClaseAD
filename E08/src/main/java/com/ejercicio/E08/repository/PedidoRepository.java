package com.ejercicio.E08.repository;

import com.ejercicio.E08.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
