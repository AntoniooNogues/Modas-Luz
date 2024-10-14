//package com.example.modasluz;
//
//import com.example.modasluz.modelos.TipoProducto;
//import com.example.modasluz.services.TipoProductoService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class TipoProductosTest {
//
//    @Autowired
//    private TipoProductoService tipoProductoService;
//
//    @Test
//    void verTodosTiposProductos(){
//        System.out.println("Tipos de productos existentes: ");
//        for (TipoProducto tipoProducto: tipoProductoService.getAll()){
//            System.out.println(tipoProducto);
//        }
//    }
//
//    @Test
//    void testCrearTipoProducto(){
//        TipoProducto tipoProducto = new TipoProducto();
//        tipoProducto.setId(4);
//        tipoProducto.setNombre("Zapatillas");
//        TipoProducto tipoProductoGuardado = tipoProductoService.guardar(tipoProducto);
//        System.out.println(tipoProductoGuardado.toString());
//    }
//
//    @Test
//    void testEliminarTipoProducto(){
//        tipoProductoService.eliminar(4);
//        System.out.println("Tipo de producto eliminado");
//        tipoProductoService.getAll().forEach(System.out::println);
//    }
//
//
//}
