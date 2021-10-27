package com.ejercicio.E08.service;

import com.ejercicio.E08.model.Empleado;
import com.ejercicio.E08.repository.EmpleadoRepository;
import com.ejercicio.E08.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService extends BaseService<Empleado, Long, EmpleadoRepository> {
}
