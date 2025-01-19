package com.example.modasluz;

import com.example.modasluz.dto.*;
import com.example.modasluz.mappers.Mappers;
import com.example.modasluz.modelos.*;
import com.example.modasluz.repositorios.CatalogoRepositorio;
import com.example.modasluz.repositorios.TallaRepositorio;
import com.example.modasluz.services.CatalogoService;
import com.example.modasluz.services.ProductoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CatalogoIntegracionTest {

    @Mock
    private TallaRepositorio tallaRepositorio;

    @Mock
    private ProductoService productoService;

    @Mock
    private CatalogoRepositorio catalogoRepositorio;

    @Mock
    private Mappers mappers;

    @InjectMocks
    private CatalogoService service;

    @Test
    public void testConsultarDisponibilidad() throws Exception {
        Talla talla = new Talla(1, "S");
        Producto producto = new Producto(1, null, "Camisa de algodon", "Camisa de algodon, elegante, para caballero", null);
        Catalogo catalogo = new Catalogo(1, producto, talla, new Color(1, "Rojo"), 10, 100.0);

        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setNombre("Camisa de algodon");
        productoDTO.setDescripcion("Camisa de algodon, elegante, para caballero");

        TallaDTO tallaDTO = new TallaDTO();
        tallaDTO.setTipo("S");

        ColorDTO colorDTO = new ColorDTO();
        colorDTO.setNombre("Rojo");

        CatalogoDTO catalogoDTO = new CatalogoDTO(productoDTO, tallaDTO, colorDTO, 15, 100.0);

        when(tallaRepositorio.findByTipo("S")).thenReturn(talla);
        when(productoService.getByIdNormal(1)).thenReturn(producto);
        when(catalogoRepositorio.findByProductoIdAndTallaId(1, 1)).thenReturn(catalogo);
        when(mappers.toDTO(catalogo)).thenReturn(catalogoDTO);

        CatalogoDTO result = service.consultarDisponibilidad(1, "S");

        assertNotNull(result);
        assertEquals("Camisa de algodon", result.getProducto().getNombre());
        assertEquals("S", result.getTalla().getTipo());
        assertEquals(15, result.getCantidad());
        assertEquals(100.0, result.getPrecio());
    }

    @Test
    public void testModificarStock() throws Exception {
        Talla talla = new Talla(1, "S");
        Producto producto = new Producto(1, null, "Camisa de algodon", "Camisa de algodon, elegante, para caballero", null);
        Catalogo catalogo = new Catalogo(1, producto, talla, new Color(1, "Rojo"), 10, 100.0);

        CatalogoPersonalizadoDTO catalogoPersonalizadoDTO = new CatalogoPersonalizadoDTO(1, "S", 15);
        catalogo.setCantidad(15);

        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setNombre("Camisa de algodon");
        productoDTO.setDescripcion("Camisa de algodon, elegante, para caballero");

        TallaDTO tallaDTO = new TallaDTO();
        tallaDTO.setTipo("S");

        ColorDTO colorDTO = new ColorDTO();
        colorDTO.setNombre("Rojo");

        CatalogoDTO catalogoDTO = new CatalogoDTO(productoDTO, tallaDTO, colorDTO, 15, 100.0);

        lenient().when(tallaRepositorio.findByTipo("S")).thenReturn(talla);
        lenient().when(productoService.getByIdNormal(1)).thenReturn(producto);
        lenient().when(catalogoRepositorio.findByProductoIdAndTallaId(1, 1)).thenReturn(catalogo);
        lenient().when(mappers.toDTO(catalogo)).thenReturn(catalogoDTO);
        lenient().when(catalogoRepositorio.save(catalogo)).thenReturn(catalogo);

        CatalogoDTO result = service.modificarStock(catalogoPersonalizadoDTO);

        assertNotNull(result);
        assertEquals(15, result.getCantidad());
        verify(catalogoRepositorio, times(1)).save(catalogo);
    }

    @Test
    public void testGetAllDTOConDatos() {
        Talla talla = new Talla(1, "S");
        Producto producto = new Producto(1, null, "Camisa de algodon", "Camisa de algodon, elegante, para caballero", null);
        Catalogo catalogo = new Catalogo(1, producto, talla, new Color(1, "Rojo"), 10, 100.0);

        lenient().when(catalogoRepositorio.findAll()).thenReturn(Arrays.asList(catalogo));

        CatalogoDTO catalogoDTO = new CatalogoDTO(
                new ProductoDTO("Camisa de algodon", "Camisa de algodon, elegante, para caballero"),
                new TallaDTO("S"),
                new ColorDTO("Rojo"),
                10,
                100.0
        );

        lenient().when(mappers.toDTO(catalogo)).thenReturn(catalogoDTO);

        // Verificar que findAll devuelve la lista esperada
        List<Catalogo> catalogoList = catalogoRepositorio.findAll();
        assertNotNull(catalogoList);
        assertEquals(1, catalogoList.size());
        assertEquals("Camisa de algodon", catalogoList.get(0).getProducto().getNombre());

        // Verificar que toDTO convierte correctamente la entidad
        CatalogoDTO dto = mappers.toDTO(catalogo);
        assertNotNull(dto);
        assertEquals("Camisa de algodon", dto.getProducto().getNombre());

        // Ejecutar el método del servicio y verificar el resultado
        List<CatalogoDTO> catalogoDTOList = service.getAllDTO();
        assertNotNull(catalogoDTOList);
        assertEquals(1, catalogoDTOList.size());
        assertEquals("Camisa de algodon", catalogoDTOList.get(0).getProducto().getNombre());
    }
}