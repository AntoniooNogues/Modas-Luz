package com.example.modasluz;

import com.example.modasluz.modelos.*;
import com.example.modasluz.repositorios.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ModasLuzApplicationTests {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private CatalogoRepositorio catalogoRepositorio;

    @Autowired
    private TipoProductoRepositorio tipoProductoRepositorio;

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private RegistroVentaRepositorio registroVentaRepositorio;

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private TallaRepositorio tallaRepositorio;

    @Autowired
    private TipoPagoRepositorio tipoPagoRepositorio;

    @Autowired
    private StockRepositorio stockRepositorio;

    @Autowired
    private ColorRepositorio colorRepositorio;

    @Autowired
    private TipoProductoPrecioRepositorio tipoProductoPrecioRepositorio;

    @Test
    void contextLoads() {
        assertNotNull(productoRepositorio);
        assertNotNull(tallaRepositorio);
        assertNotNull(colorRepositorio);
        assertNotNull(tipoProductoPrecioRepositorio);
        assertNotNull(stockRepositorio);
        assertNotNull(tipoPagoRepositorio);
        assertNotNull(registroVentaRepositorio);
        assertNotNull(pedidoRepositorio);
        assertNotNull(tipoProductoRepositorio);
        assertNotNull(catalogoRepositorio);
        assertNotNull(clienteRepositorio);

    }

}
