package com.example.modasluz;

import com.example.modasluz.dto.*;
import com.example.modasluz.modelos.*;
import com.example.modasluz.repositorios.*;
import com.example.modasluz.services.CatalogoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
public class CatalogoServiceTest {

    @Autowired
    private CatalogoService service;
    @Autowired
    private CatalogoRepositorio catalogoRepositorio;
    @Autowired
    private ProductoRepositorio productoRepositorio;
    @Autowired
    private TallaRepositorio tallaRepositorio;
    @Autowired
    private ColorRepositorio colorRepositorio;
    @Autowired
    private TipoProductoRepositorio tipoProductoRepositorio;

    /*Cargar datos a la base de datos en memoria.*/
    @BeforeEach
    public void inicializarDatos(){
        Talla talla = new Talla(1,"S");
        Talla talla1 = new Talla(2,"M");
        Talla talla2 = new Talla(3,"L");
        tallaRepositorio.save(talla);
        tallaRepositorio.save(talla1);
        tallaRepositorio.save(talla2);

        Color color = new Color(1,"Rojo");
        Color color1 = new Color(2,"Azul");
        Color color2 = new Color(3,"Verde");
        colorRepositorio.save(color);
        colorRepositorio.save(color1);
        colorRepositorio.save(color2);

        TipoProducto tipoProducto = new TipoProducto(1,"Camisa");
        TipoProducto tipoProducto1 = new TipoProducto(2,"Pantalon");
        TipoProducto tipoProducto2 = new TipoProducto(3,"Camiseta");
        tipoProductoRepositorio.save(tipoProducto);
        tipoProductoRepositorio.save(tipoProducto1);
        tipoProductoRepositorio.save(tipoProducto2);

        Producto producto = new Producto(1, tipoProducto, "Camisa de algodon", "Camisa de algodon, elegante, para caballero", null);
        Producto producto1 = new Producto(2, tipoProducto1, "Pantalon de mezclilla", "Pantalon de mezclilla, casual, para caballero", null);
        Producto producto2 = new Producto(3, tipoProducto2, "Camiseta de algodon", "Camiseta de algodon, casual, con estampado de una Tormenta", null);
        productoRepositorio.save(producto);
        productoRepositorio.save(producto1);
        productoRepositorio.save(producto2);

        Catalogo catalogo = new Catalogo(1, producto, talla, color, 10, 100.0);
        Catalogo catalogo1 = new Catalogo(2, producto1, talla1, color1, 20, 200.0);
        Catalogo catalogo2 = new Catalogo(3, producto2, talla2, color2, 30, 300.0);
        catalogoRepositorio.save(catalogo);
        catalogoRepositorio.save(catalogo1);
        catalogoRepositorio.save(catalogo2);
    }

    @Test
    public void consultarDisponibilidadPostivo() throws Exception {
        TipoProductoDTO tipoProducto = new TipoProductoDTO("Camisa");
        CatalogoDTO catalogoSalida = new CatalogoDTO();
        catalogoSalida.setProducto(new ProductoDTO(tipoProducto, "Camisa de algodon", "Camisa de algodon, elegante, para caballero", null));
        catalogoSalida.setTalla(new TallaDTO("S"));
        catalogoSalida.setColor(new ColorDTO("Rojo"));
        catalogoSalida.setCantidad(10);
        catalogoSalida.setPrecio(100.0);

        CatalogoDTO actualCatalogo = service.consultarDisponibilidad(1, "S");
        assertNotNull(actualCatalogo);
        assertEquals(catalogoSalida, actualCatalogo);
    }

    /*Si la talla y el producto no existe salta la excepción del producto ya que esta posicionado antes que la talla*/

    /*Talla no disponible en base de datos, existe el producto*/
    @Test
    public void consultarDisponibilidadTallaNoEncontrada() {
        Exception exception = assertThrows(Exception.class, () -> service.consultarDisponibilidad(1, "XL"));
        assertEquals("La talla seleccionada no se encuentra en el catalogo", exception.getMessage());
    }

    /*Producto no existe, talla existe.*/
    @Test
    public void consultarDisponibilidadProductoNoEncontrado() {
        Exception exception = assertThrows(Exception.class, () -> service.consultarDisponibilidad(999, "S"));
        assertEquals("El producto con el id: 999 no existe", exception.getMessage());
    }

    /*Existe el producto y la talla, pero no hay ninguna entrada en el catalogo asociandolos entre ambos.*/
    @Test
    public void consultarDisponibilidadNegativo() {
        Exception exception= assertThrows(Exception.class, ()-> service.consultarDisponibilidad(1, "L"));
        assertEquals("El producto no se encuentra disponible en la talla seleccionada en el catalogo", exception.getMessage());
    }



    @Test
    public void modificarStockPositivo() throws Exception {
        CatalogoPersonalizadoDTO catalogoPersonalizadoDTO = new CatalogoPersonalizadoDTO(1, "S", 5);
        CatalogoDTO catalogoSalida = new CatalogoDTO();
        catalogoSalida.setProducto(new ProductoDTO(new TipoProductoDTO("Camisa"), "Camisa de algodon", "Camisa de algodon, elegante, para caballero", null));
        catalogoSalida.setTalla(new TallaDTO("S"));
        catalogoSalida.setColor(new ColorDTO("Rojo"));
        catalogoSalida.setCantidad(5);
        catalogoSalida.setPrecio(100.0);

        CatalogoDTO actualCatalogo = service.modificarStock(catalogoPersonalizadoDTO);
        assertNotNull(actualCatalogo);
        assertEquals(catalogoSalida, actualCatalogo);
    }

    /*Talla no disponible en base de datos, existe el producto*/
    @Test
    public void modificarStockTallaNoEncontrada() {
        CatalogoPersonalizadoDTO catalogoPersonalizadoDTO = new CatalogoPersonalizadoDTO(1, "XL", 5);
        Exception exception = assertThrows(Exception.class, () -> service.modificarStock(catalogoPersonalizadoDTO));
        assertEquals("La talla seleccionada no se encuentra en el catalogo", exception.getMessage());
    }

    /*El producto no esta registrado en  Catalogo o no tambien puede no haber un producto asociado a ese id*/
    @Test
    public  void modificarStockProductoNoEncontrado(){
        CatalogoPersonalizadoDTO catalogoPersonalizadoDTO = new CatalogoPersonalizadoDTO(999, "S", 5);
        Exception exception = assertThrows(Exception.class, () -> service.modificarStock(catalogoPersonalizadoDTO));
        assertEquals("El producto no se encuentra en el catalogo", exception.getMessage());
    }

    @Test
    public void listarCatalogo() throws Exception{
        assertEquals(3, service.getAllDTO().size());
    }

    /*Se borran los datos de la tabla para ver que pasa en caso de que no haya elementos en catalogo*/
    @Test
    public void listarCatalogoVacio() {
        catalogoRepositorio.deleteAll();
        Exception exception = assertThrows(RuntimeException.class, () -> service.getAllDTO());
        assertEquals("No hay datos en el catalogo", exception.getMessage());
    }
}

