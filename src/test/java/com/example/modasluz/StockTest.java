package com.example.modasluz;

import com.example.modasluz.modelos.*;
import com.example.modasluz.services.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StockTest {

    @Autowired
    private StockService stockService;
    @Autowired
    private ProductoService productoService;
    @Autowired
    private TallaService tallaService;

    @Test
    public void verStock() {
        for (Stock s: stockService.getAll()) {
            System.out.println(s);
        }
    }

    @Test
    public void agregarStock() {
        Stock s = new Stock();
        Producto producto = productoService.getById(1);
        Talla talla = tallaService.getById(1);
        s.setId(4);
        s.setProducto(producto);
        s.setTalla(talla);
        s.setCantidad(10);
        stockService.guardar(s);
        System.out.println("Stock agregado");
    }

    @Test
    public void verStockPorId() {
        System.out.println(stockService.getById(4));
    }

    @Test
    public void eliminarStock() {
        stockService.eliminar(4);
        System.out.println("Stock eliminado");
    }
}
