package com.ejercicio.E08.service;

import com.ejercicio.E08.model.Pedido;
import com.ejercicio.E08.repository.PedidoRepository;
import com.ejercicio.E08.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PedidoService extends BaseService<Pedido, Long, PedidoRepository> {
}
