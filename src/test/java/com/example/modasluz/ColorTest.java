//package com.example.modasluz;
//
//import com.example.modasluz.modelos.Cliente;
//import com.example.modasluz.modelos.Color;
//import com.example.modasluz.services.ClienteService;
//import com.example.modasluz.services.ColorService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class ColorTest {
//
//    @Autowired
//    private ColorService colorService;
//
//
//
//    @Test
//    public void verColor() {
//        for (Color c: colorService.getAll()) {
//            System.out.println(c);
//        }
//    }
//
//    @Test
//    public void agregarColor() {
//        Color c = new Color();
//        c.setId(4);
//        c.setNombre("Purpura");
//        colorService.guardar(c);
//        System.out.println("Color agregado");
//    }
//
//    @Test
//    public void verColorPorId() {
//        System.out.println(colorService.getById(4));
//    }
//
//    @Test
//    public void eliminarColor() {
//        colorService.eliminar(4);
//        System.out.println("Color eliminado");
//    }
//}
