package com.example.modasluz;

import com.example.modasluz.modelos.Catalogo;
import com.example.modasluz.modelos.Producto;
import com.example.modasluz.services.CatalogoService;
import com.example.modasluz.services.ProductoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CatalogoTest {

    @Autowired
    private CatalogoService catalogoService;

    @Autowired
    private ProductoService productoService;

    @Test
    public void verCatalogo() {
        for (Catalogo c: catalogoService.getAll()) {
            System.out.println(c);
        }
    }

    @Test
    public void agregarCatalogo() {
        Producto producto = productoService.getById(2);
        Catalogo c = new Catalogo();
        c.setId(4);
        c.setProducto(producto);
        c.setPrecio(56.4);
        catalogoService.guardar(c);
    }

    @Test
    public void verCatalogoPorId() {
        System.out.println(catalogoService.getById(4));
    }

    @Test
    public void eliminarCatalogo() {
        catalogoService.eliminar(4);
        System.out.println("Catalogo eliminado");
    }
}
