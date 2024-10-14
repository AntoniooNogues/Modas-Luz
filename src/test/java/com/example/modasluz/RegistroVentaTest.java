//package com.example.modasluz;
//
//import com.example.modasluz.modelos.*;
//import com.example.modasluz.services.*;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDate;
//
//@SpringBootTest
//public class RegistroVentaTest {
//
//    @Autowired
//    private RegistroVentaService registroVentaService;
//    @Autowired
//    private ProductoService productoService;
//    @Autowired
//    private PedidoService pedidoService;
//
//    @Test
//    public void verRegistro() {
//        for (RegistroVenta rv: registroVentaService.getAll()) {
//            System.out.println(rv);
//        }
//    }
//
//    @Test
//    public void agregarRegistro() {
//        RegistroVenta rv = new RegistroVenta();
//        Producto producto = productoService.getById(1);
//        Pedido pedido = pedidoService.getById(1);
//        rv.setId(4);
//        rv.setProducto(producto);
//        rv.setPedido(pedido);
//        rv.setCantidad(10);
//        rv.setPrecio_venta(34.99);
//        registroVentaService.guardar(rv);
//        System.out.println("Registro de venta agregado");
//    }
//
//    @Test
//    public void verRegistroPorId() {
//        System.out.println(registroVentaService.getById(4));
//    }
//
//    @Test
//    public void eliminarRegistro() {
//        registroVentaService.eliminar(4);
//        System.out.println("Registro de venta eliminado");
//    }
//}
