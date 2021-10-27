package com.ejercicio.E08.service;

import com.ejercicio.E08.model.Cliente;
import com.ejercicio.E08.repository.ClienteRepository;
import com.ejercicio.E08.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends BaseService<Cliente, Long, ClienteRepository> {
}
