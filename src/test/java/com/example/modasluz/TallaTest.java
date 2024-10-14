//package com.example.modasluz;
//
//import com.example.modasluz.modelos.Producto;
//import com.example.modasluz.modelos.Stock;
//import com.example.modasluz.modelos.Talla;
//import com.example.modasluz.services.ProductoService;
//import com.example.modasluz.services.StockService;
//import com.example.modasluz.services.TallaService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class TallaTest {
//
//    @Autowired
//    private TallaService tallaService;
//
//    @Test
//    public void verTalla() {
//        for (Talla t: tallaService.getAll()) {
//            System.out.println(t);
//        }
//    }
//
//    @Test
//    public void agregarTalla() {
//        Talla talla = new Talla();
//        talla.setId(4);
//        talla.setTipo("XXXXL"); // Como maximo 5 caracteres
//        tallaService.guardar(talla);
//        System.out.println("Nueva talla agregado");
//    }
//
//    @Test
//    public void verTallaPorId() {
//        System.out.println(tallaService.getById(4));
//    }
//
//    @Test
//    public void eliminarTalla() {
//        tallaService.eliminar(4);
//        System.out.println("Talla eliminado");
//    }
//}
