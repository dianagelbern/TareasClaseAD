package com.ejercicio.E08.repository;

import com.ejercicio.E08.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
