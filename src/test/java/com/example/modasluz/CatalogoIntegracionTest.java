package com.example.modasluz;

import com.example.modasluz.dto.*;
import com.example.modasluz.mappers.CatalogoMapper;
import com.example.modasluz.modelos.*;
import com.example.modasluz.repositorios.*;
import com.example.modasluz.services.CatalogoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CatalogoIntegracionTest {

    @InjectMocks
    private CatalogoService service;
    @Mock
    private CatalogoRepositorio catalogoRepositorio;
    @Mock
    private ProductoRepositorio productoRepositorio;
    @Mock
    private TallaRepositorio tallaRepositorio;
    @Mock
    private CatalogoMapper catalogoMapper;

    @Test
    public void consultarDisponibilidadPostivo() throws Exception {
        //GIVEN
        Producto producto = new Producto();
        producto.setId(1);
        Talla talla = new Talla();
        talla.setId(1);
        talla.setTipo("M");
        Catalogo catalogo = new Catalogo();
        catalogo.setProducto(producto);
        catalogo.setTalla(talla);
        catalogo.setCantidad(10);

        when(productoRepositorio.findById(1)).thenReturn(java.util.Optional.of(producto));
        when(tallaRepositorio.findByTipo("M")).thenReturn(talla);
        when(catalogoRepositorio.findByProductoIdAndTallaId(1, 1)).thenReturn(catalogo);

        //WHEN
        CatalogoDTO result = service.consultarDisponibilidad(1, "M");

        //THEN
        assertNotNull(result);
        assertEquals(10, result.getCantidad());
        verify(productoRepositorio, times(1)).findById(1);
        verify(tallaRepositorio, times(1)).findByTipo("M");
        verify(catalogoRepositorio, times(1)).findByProductoIdAndTallaId(1, 1);
    }

    @Test
    public void consultarDisponibilidadTallaNoEncontrada() {
        //GIVEN
        when(tallaRepositorio.findByTipo("M")).thenReturn(null);

        //WHEN
        Exception exception = assertThrows(Exception.class, () -> service.consultarDisponibilidad(1, "M"));

        //THEN
        assertEquals("La talla seleccionada no se encuentra en el catalogo", exception.getMessage());
        verify(tallaRepositorio, times(1)).findByTipo("M");
    }

    @Test
    public void consultarDisponibilidadProductoNoEncontrado() {
        //GIVEN
        Talla talla = new Talla();
        talla.setId(1);
        talla.setTipo("M");

        when(tallaRepositorio.findByTipo("M")).thenReturn(talla);
        when(productoRepositorio.findById(1)).thenReturn(java.util.Optional.empty());

        //WHEN
        Exception exception = assertThrows(Exception.class, () -> service.consultarDisponibilidad(1, "M"));

        //THEN
        assertEquals("El producto con el id: 1 no existe", exception.getMessage());
        verify(tallaRepositorio, times(1)).findByTipo("M");
        verify(productoRepositorio, times(1)).findById(1);
    }

    @Test
    public void consultarDisponibilidadNegativo() {
        //GIVEN
        Producto producto = new Producto();
        producto.setId(1);
        Talla talla = new Talla();
        talla.setId(1);
        talla.setTipo("M");

        when(productoRepositorio.findById(1)).thenReturn(java.util.Optional.of(producto));
        when(tallaRepositorio.findByTipo("M")).thenReturn(talla);
        when(catalogoRepositorio.findByProductoIdAndTallaId(1, 1)).thenReturn(null);

        //WHEN
        Exception exception = assertThrows(Exception.class, () -> service.consultarDisponibilidad(1, "M"));

        //THEN
        assertEquals("El producto no se encuentra disponible en la talla seleccionada en el catalogo", exception.getMessage());
        verify(productoRepositorio, times(1)).findById(1);
        verify(tallaRepositorio, times(1)).findByTipo("M");
        verify(catalogoRepositorio, times(1)).findByProductoIdAndTallaId(1, 1);
    }

    @Test
    public void modificarStockPositivo() throws Exception {
        //GIVEN
        Producto producto = new Producto();
        producto.setId(1);
        Talla talla = new Talla();
        talla.setId(1);
        talla.setTipo("M");
        Catalogo catalogo = new Catalogo();
        catalogo.setProducto(producto);
        catalogo.setTalla(talla);
        catalogo.setCantidad(10);

        CatalogoPersonalizadoDTO dto = new CatalogoPersonalizadoDTO(1, "M", 20);

        when(tallaRepositorio.findByTipo("M")).thenReturn(talla);
        when(catalogoRepositorio.findByProductoIdAndTallaId(1, 1)).thenReturn(catalogo);
        when(catalogoRepositorio.save(any(Catalogo.class))).thenReturn(catalogo);

        //WHEN
        CatalogoDTO result = service.modificarStock(dto);

        //THEN
        assertNotNull(result);
        assertEquals(20, result.getCantidad());
        verify(tallaRepositorio, times(1)).findByTipo("M");
        verify(catalogoRepositorio, times(1)).findByProductoIdAndTallaId(1, 1);
        verify(catalogoRepositorio, times(1)).save(any(Catalogo.class));
    }

    @Test
    public void modificarStockTallaNoEncontrada() {
        //GIVEN
        CatalogoPersonalizadoDTO dto = new CatalogoPersonalizadoDTO(1, "M", 20);

        when(tallaRepositorio.findByTipo("M")).thenReturn(null);

        //WHEN
        Exception exception = assertThrows(Exception.class, () -> service.modificarStock(dto));

        //THEN
        assertEquals("La talla seleccionada no se encuentra en el catalogo", exception.getMessage());
        verify(tallaRepositorio, times(1)).findByTipo("M");
    }

    @Test
    public void modificarStockProductoNoEncontrado() {
        //GIVEN
        Talla talla = new Talla();
        talla.setId(1);
        talla.setTipo("M");
        CatalogoPersonalizadoDTO dto = new CatalogoPersonalizadoDTO(1, "M", 20);

        when(tallaRepositorio.findByTipo("M")).thenReturn(talla);
        when(catalogoRepositorio.findByProductoIdAndTallaId(1, 1)).thenReturn(null);

        //WHEN
        Exception exception = assertThrows(Exception.class, () -> service.modificarStock(dto));

        //THEN
        assertEquals("El producto no se encuentra en el catalogo", exception.getMessage());
        verify(tallaRepositorio, times(1)).findByTipo("M");
        verify(catalogoRepositorio, times(1)).findByProductoIdAndTallaId(1, 1);
    }

    @Test
    public void listarCatalogo() {
        List<Catalogo> catalogos = new ArrayList<>();
        catalogos.add(new Catalogo(1, new Producto(1, new TipoProducto(1, "Camisa"), "Camisa de algodon", "Camisa de algodon, elegante, para caballero", null), new Talla(1, "S"), new Color(1, "Rojo"), 10, 100.0));
        catalogos.add(new Catalogo(2, new Producto(2, new TipoProducto(2, "Pantalon"), "Pantalon de mezclilla", "Pantalon de mezclilla, casual, para caballero", null), new Talla(2, "M"), new Color(2, "Azul"), 20, 200.0));
        catalogos.add(new Catalogo(3, new Producto(3, new TipoProducto(3, "Camiseta"), "Camiseta de algodon", "Camiseta de algodon, casual, con estampado de una Tormenta", null), new Talla(3, "L"), new Color(3, "Verde"), 30, 300.0));

        List<CatalogoDTO> catalogoDTOs = new ArrayList<>();
        catalogoDTOs.add(new CatalogoDTO(new ProductoDTO(new TipoProductoDTO("Camisa"), "Camisa de algodon", "Camisa de algodon, elegante, para caballero", null), new TallaDTO("S"), new ColorDTO("Rojo"), 10, 10.00));
        catalogoDTOs.add(new CatalogoDTO(new ProductoDTO(new TipoProductoDTO("Pantalon"), "Pantalon de mezclilla", "Pantalon de mezclilla, casual, para caballero", null), new TallaDTO("M"), new ColorDTO("Azul"), 20, 20.00));
        catalogoDTOs.add(new CatalogoDTO(new ProductoDTO(new TipoProductoDTO("Camiseta"), "Camiseta de algodon", "Camiseta de algodon, casual, con estampado de una Tormenta", null), new TallaDTO("L"), new ColorDTO("Verde"), 30, 30.00));

        Mockito.when(catalogoRepositorio.findAll()).thenReturn(catalogos);
        Mockito.when(catalogoMapper.toDTO(anyList())).thenReturn(catalogoDTOs);

        assertEquals(3, service.getAllDTO().size());
        Mockito.verify(catalogoRepositorio, times(1)).findAll();
        Mockito.verify(catalogoMapper, times(1)).toDTO(anyList());
    }

    @Test
    public void listarCatalogoVacio() {
        when(catalogoRepositorio.findAll()).thenReturn(new ArrayList<>());
        Exception exception = assertThrows(RuntimeException.class, () -> service.getAllDTO());
        assertEquals("No hay datos en el catalogo", exception.getMessage());
        verify(catalogoRepositorio, times(1)).findAll();
    }
}