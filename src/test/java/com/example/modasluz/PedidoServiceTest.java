package com.example.modasluz;

import com.example.modasluz.dto.PedidoPersonalizadoDTO;
import com.example.modasluz.enums.EstatusPago;
import com.example.modasluz.enums.MetodoPago;
import com.example.modasluz.enums.Rol;
import com.example.modasluz.modelos.*;
import com.example.modasluz.repositorios.*;
import com.example.modasluz.services.PedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
public class PedidoServiceTest {

    @Autowired
    private PedidoService service;

    @Autowired
    private PedidoRepositorio repositorio;
    @Autowired
    private TipoPagoRepositorio tipoPagoRepositorio;
    @Autowired
    private PedidoRepositorio pedidoRepositorio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private ProductoRepositorio productoRepositorio;
    @Autowired
    private TallaRepositorio tallaRepositorio;
    @Autowired
    private ColorRepositorio colorRepositorio;
    @Autowired
    private TipoProductoRepositorio tipoProductoRepositorio;
    @Autowired
    private CatalogoRepositorio catalogoRepositorio;

    /*Cargar datos a la base de datos en memoria.*/
    @BeforeEach
    public void inicializarDatos(){
        Usuario usuario = new Usuario(1, "Juan", "Perez García", "Juanpe", Rol.CLIENTE, "juanpe@gmail.com", "12345678A", "Aragon", 31045);
        usuarioRepositorio.save(usuario);
        TipoPago tipoPago = new TipoPago(1, MetodoPago.TARJETA, EstatusPago.PAGADO, "123456789");
        tipoPagoRepositorio.save(tipoPago);

        Talla talla = new Talla(1,"S");
        Talla talla1 = new Talla(2,"M");
        Talla talla2 = new Talla(3,"L");
        tallaRepositorio.save(talla);
        tallaRepositorio.save(talla1);
        tallaRepositorio.save(talla2);

        Color color = new Color(1,"Rojo");
        Color color1 = new Color(2,"Azul");
        Color color2 = new Color(3,"Verde");
        colorRepositorio.save(color);
        colorRepositorio.save(color1);
        colorRepositorio.save(color2);

        TipoProducto tipoProducto = new TipoProducto(1,"Camisa");
        TipoProducto tipoProducto1 = new TipoProducto(2,"Pantalon");
        TipoProducto tipoProducto2 = new TipoProducto(3,"Camiseta");
        tipoProductoRepositorio.save(tipoProducto);
        tipoProductoRepositorio.save(tipoProducto1);
        tipoProductoRepositorio.save(tipoProducto2);

        Producto producto = new Producto(1, tipoProducto, "Camisa de algodon", "Camisa de algodon, elegante, para caballero", null);
        Producto producto1 = new Producto(2, tipoProducto1, "Pantalon de mezclilla", "Pantalon de mezclilla, casual, para caballero", null);
        Producto producto2 = new Producto(3, tipoProducto2, "Camiseta de algodon", "Camiseta de algodon, casual, con estampado de una Tormenta", null);
        productoRepositorio.save(producto);
        productoRepositorio.save(producto1);
        productoRepositorio.save(producto2);

        Catalogo catalogo = new Catalogo(1, producto, talla, color, 10, 100.0);
        Catalogo catalogo1 = new Catalogo(2, producto1, talla1, color1, 20, 200.0);
        Catalogo catalogo2 = new Catalogo(3, producto2, talla2, color2, 30, 300.0);
        catalogoRepositorio.save(catalogo);
        catalogoRepositorio.save(catalogo1);
        catalogoRepositorio.save(catalogo2);

    }

    @Test
    public void testGuardarPedido() throws Exception{
        PedidoPersonalizadoDTO pedidoPersonalizadoDTO = new PedidoPersonalizadoDTO();
        pedidoPersonalizadoDTO.setId_cliente(usuarioRepositorio.findById(1).get().getId());
        pedidoPersonalizadoDTO.setId_tipo_pago(tipoPagoRepositorio.findById(1).get().getId());
        pedidoPersonalizadoDTO.setFecha(LocalDate.now().plusYears(2));
        pedidoPersonalizadoDTO.getProductos().add(productoRepositorio.findById(1).get().getId());
        pedidoPersonalizadoDTO.getProductos().add(productoRepositorio.findById(2).get().getId());
        pedidoPersonalizadoDTO.getProductos().add(productoRepositorio.findById(3).get().getId());
        pedidoPersonalizadoDTO.getCantidades().add(4);
        pedidoPersonalizadoDTO.getCantidades().add(2);
        pedidoPersonalizadoDTO.getCantidades().add(3);

        String result = service.crearPedidoPersonalizado(pedidoPersonalizadoDTO);
        assertNotNull(result, "Error a la hora de crear un pedido");
        assertEquals("Pedido creado correctamente", result);
    }

    @Test
    public void testGuardarPedidoNegativo(){
        PedidoPersonalizadoDTO pedidoPersonalizadoDTO = new PedidoPersonalizadoDTO();
        pedidoPersonalizadoDTO.setId_cliente(99);
        pedidoPersonalizadoDTO.setId_tipo_pago(tipoPagoRepositorio.findById(1).get().getId());
        pedidoPersonalizadoDTO.setFecha(LocalDate.now().plusYears(2));
        pedidoPersonalizadoDTO.getProductos().add(productoRepositorio.findById(1).get().getId());
        pedidoPersonalizadoDTO.getProductos().add(productoRepositorio.findById(2).get().getId());
        pedidoPersonalizadoDTO.getProductos().add(productoRepositorio.findById(3).get().getId());
        pedidoPersonalizadoDTO.getCantidades().add(15);
        pedidoPersonalizadoDTO.getCantidades().add(-6);
        pedidoPersonalizadoDTO.getCantidades().add(-50);


        Exception e =  assertThrows(Exception.class, () -> service.crearPedidoPersonalizado(pedidoPersonalizadoDTO));
        assertEquals("Error a la hora de crear un pedido", e.getMessage());
    }
}

