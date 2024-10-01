package com.example.modasluz;

import com.example.modasluz.modelos.Producto;
import com.example.modasluz.modelos.TipoProducto;
import com.example.modasluz.services.ProductoService;
import com.example.modasluz.services.TipoProductoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductosTest {


    @Autowired
    ProductoService productoService;

    @Test
    void verTodosProductos(){
        System.out.println("Productos: ");
        for (Producto producto: productoService.getAll()){
            System.out.println(producto);
        }
    }

    @Test
    void testCrearProducto(){
        TipoProducto tipoProducto = new TipoProducto();
        tipoProducto.setId(1);
        tipoProducto.setNombre("Ropa");
        Producto producto = new Producto();
        producto.setId(4);
        producto.setNombre("Cargo");
        producto.setDescripcion("Composicion: 100% algodon");
        producto.setTipo_producto(tipoProducto);
        Producto productoGuardado = productoService.guardar(producto);
        System.out.println(productoGuardado.toString());
    }




}
