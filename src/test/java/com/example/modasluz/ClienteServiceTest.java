package com.example.modasluz;

import com.example.modasluz.dto.*;
import com.example.modasluz.enums.EstatusPago;
import com.example.modasluz.enums.MetodoPago;
import com.example.modasluz.enums.Rol;
import com.example.modasluz.modelos.*;
import com.example.modasluz.repositorios.*;
import com.example.modasluz.services.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
public class ClienteServiceTest {

    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioRepositorio repositorio;
    @Autowired
    private TipoPagoRepositorio tipoPagoRepositorio;
    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    /*Cargar datos a la base de datos en memoria.*/
    @BeforeEach
    public void inicializarDatos(){
        TipoPago tipoPago = new TipoPago(1, MetodoPago.EFECTIVO, EstatusPago.PAGADO, "123456789");
        tipoPagoRepositorio.save(tipoPago);

        Usuario usuario = new Usuario(1, "Juan", "Perez García", "Juanpe", Rol.CLIENTE, "juanpe@gmail.com", "12345678A", "Aragon", 31045);
        repositorio.save(usuario);

        Pedido pedido = new Pedido(1, usuario, tipoPago, LocalDate.now(), "123456789");
        pedidoRepositorio.save(pedido);
        Pedido pedido2 = new Pedido(2, usuario, tipoPago, LocalDate.now().minusMonths(2), "123456789");
        pedidoRepositorio.save(pedido2);
        Usuario usuario2 = new Usuario(2, "Maria", "Gonzalez Lopez", "Mariagl", Rol.CLIENTE, "mariagl@gmail.com", "87654321B", "Madrid", 28045);
        repositorio.save(usuario2);

    }

    @Test
    public void eliminarUsuarioPositivo() throws Exception {
        String resultado = service.eliminar(1);
        assertEquals("Cliente eliminado correctamente", resultado);
    }

    @Test
    public void eliminarUsuarioNegativo() {
        Exception exception = assertThrows(Exception.class, () -> service.eliminar(99));
        assertEquals("No se ha encontrado un cliente con el id ingresado", exception.getMessage());
    }

    @Test
    public void getPedidosClientePositivo() throws Exception {
        UsuarioDTOPedidos usuarioDTOPedidos = service.getPedidosDeCliente(1);
        assertNotNull(usuarioDTOPedidos);
        assertEquals(2, usuarioDTOPedidos.getPedidosDTO().size());
    }

    @Test
    public void getPedidosClienteUsuarioNoExiste(){
        Exception exception = assertThrows(Exception.class, () -> service.getPedidosDeCliente(99));
        assertEquals("No se ha encontrado un cliente con el id ingresado", exception.getMessage());
    }

    @Test
    public void getPedidosClienteSinPedidos() {
        Exception exception = assertThrows(Exception.class, () -> service.getPedidosDeCliente(2));
        assertEquals("El cliente no tiene pedidos asociados", exception.getMessage());
    }
}

