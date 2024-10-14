//package com.example.modasluz;
//
//import com.example.modasluz.modelos.Cliente;
//import com.example.modasluz.services.ClienteService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class ClienteTest {
//
//    @Autowired
//    private ClienteService clienteService;
//
//
//
//    @Test
//    public void verCliente() {
//        for (Cliente c: clienteService.getAll()) {
//            System.out.println(c);
//        }
//    }
//
//    @Test
//    public void agregarCliente() {
//        Cliente c = new Cliente();
//        c.setId(4);
//        c.setNombre("Jose Ramón");
//        c.setApellidos("Santos de la Paz");
//        c.setDireccion("C/ 27 de Febrero # 23, Villa Mella");
//        c.setCodigo_postal(20145);
//        c.setDni("41478951B");
//        clienteService.guardar(c);
//        System.out.println("Cliente agregado");
//    }
//
//    @Test
//    public void verClientePorId() {
//        System.out.println(clienteService.getById(4));
//    }
//
//    @Test
//    public void eliminarCliente() {
//        clienteService.eliminar(1);
//        System.out.println("Catalogo eliminado");
//    }
//}
