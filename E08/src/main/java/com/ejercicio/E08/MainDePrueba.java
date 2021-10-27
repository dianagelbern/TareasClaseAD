package com.ejercicio.E08;


import ch.qos.logback.core.net.server.Client;
import com.ejercicio.E08.model.*;
import com.ejercicio.E08.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MainDePrueba {

    private final CleinteIndividualService cleinteIndividualService;
    private final ClienteCorporativoService clienteCorporativoService;
    private final ClienteService clienteService;
    private final EmpleadoService empleadoService;
    private final PedidoService pedidoService;

    @PostConstruct
    public void test(){


        List<Cliente> clientes = Arrays.asList(Cliente.builder().nombre("Carlos")
                        .direccion("Avenida Siempre Viva")
                        .codigoPostal("45187")
                        .codCliente(160)
                        .telefono("3331490640").build(),
                Cliente.builder().nombre("Ana")
                        .direccion("Avenida Corwen")
                        .codigoPostal("45167")
                        .codCliente(127)
                        .telefono("3331490760").build());

        clientes.forEach(clienteService::save);

        Empleado e = Empleado.builder()
                .numEmpleado(340)
                .build();

        Cliente clienteC = ClienteCorporativo.builder()
                .nombre("Nielsen")
                .direccion("Wall Street, Nueva York")
                .codigoPostal("3002")
                .codCliente(130)
                .telefono("3331419040")
                .nombreCompania("Nielsen Enterprice")
                .build();

        Cliente clienteI = ClienteIndividual.builder()
                .nombre("Carmen María")
                .direccion("Avenida Gran Vía")
                .codigoPostal("3034")
                .codCliente(115)
                .telefono("3331909040")
                .email("carmen@gmail.com")
                .build();

        clienteService.save(clienteC);
        clienteService.save(clienteI);


        Pedido p = Pedido.builder()
                .numPedido(320)
                .build();

        p.addCliente(clienteI);
        pedidoService.save(p);



    }

}
