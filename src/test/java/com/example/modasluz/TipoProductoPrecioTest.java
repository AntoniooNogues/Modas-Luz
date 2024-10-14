//package com.example.modasluz;
//
//import com.example.modasluz.modelos.*;
//import com.example.modasluz.services.ColorService;
//import com.example.modasluz.services.ProductoService;
//import com.example.modasluz.services.TallaService;
//import com.example.modasluz.services.TipoProductoPrecioService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class TipoProductoPrecioTest {
//
//    @Autowired
//    private TipoProductoPrecioService tipoProductoPrecioService;
//    @Autowired
//    private ProductoService productoService;
//    @Autowired
//    private TallaService tallaService;
//
//    @Autowired
//    private ColorService colorService;
//
//    @Test
//    public void verTipoPago() {
//        for (TipoProductoPrecio t: tipoProductoPrecioService.getAll()) {
//            System.out.println(t);
//        }
//    }
//
//    @Test
//    public void agregarTipoPago() {
//        TipoProductoPrecio t = new TipoProductoPrecio();
//        Producto producto = productoService.getById(1);
//        Talla talla = tallaService.getById(1);
//        Color color = colorService.getById(1);
//        t.setId(4);
//        t.setProducto(producto);
//        t.setTalla(talla);
//        t.setColor(color);
//        t.setPrecio(52.00);
//        tipoProductoPrecioService.guardar(t);
//        System.out.println("Tipo de producto precio agregado");
//    }
//
//    @Test
//    public void verTipoPagoPorId() {
//        System.out.println(tipoProductoPrecioService.getById(4));
//    }
//
//    @Test
//    public void eliminarTipoPago() {
//        tipoProductoPrecioService.eliminar(4);
//        System.out.println("Tipo de producto precio eliminado");
//    }
//}
