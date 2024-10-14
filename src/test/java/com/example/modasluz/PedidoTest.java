//package com.example.modasluz;
//
//import com.example.modasluz.modelos.Cliente;
//import com.example.modasluz.modelos.Pedido;
//import com.example.modasluz.modelos.TipoPago;
//import com.example.modasluz.services.ClienteService;
//import com.example.modasluz.services.PedidoService;
//import com.example.modasluz.services.TipoPagoService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDate;
//
//@SpringBootTest
//public class PedidoTest {
//
//    @Autowired
//    private PedidoService pedidoService;
//
//    @Autowired
//    private ClienteService clienteService;
//
//    @Autowired
//    private TipoPagoService tipoPagoService;
//
//
//    @Test
//    public void verPedido() {
//        for (Pedido p: pedidoService.getAll()) {
//            System.out.println(p);
//        }
//    }
//
//    @Test
//    public void agregarPedido() {
//        Pedido p = new Pedido();
//        Cliente cliente = clienteService.getById(1);
//        TipoPago tipoPago = tipoPagoService.getById(2);
//        p.setId(4);
//        p.setCliente(cliente);
//        p.setTipo_pago(tipoPago);
//        p.setFecha(LocalDate.of(2021, 10, 10));
//        p.setCodigo("PED004");
//        pedidoService.guardar(p);
//        System.out.println("Pedido agregado");
//    }
//
//    @Test
//    public void verPedidoPorId() {
//        System.out.println(pedidoService.getById(4));
//    }
//
//    @Test
//    public void eliminarPedido() {
//        pedidoService.eliminar(4);
//        System.out.println("Pedido eliminado");
//    }
//}
