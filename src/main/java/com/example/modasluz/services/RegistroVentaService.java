package com.example.modasluz.services;


import com.example.modasluz.dto.PedidoDTO;
import com.example.modasluz.dto.RegistroVentaDTO;
import com.example.modasluz.mappers.RegistroVentaMapper;
import com.example.modasluz.modelos.Catalogo;
import com.example.modasluz.modelos.Pedido;
import com.example.modasluz.modelos.RegistroVenta;
import com.example.modasluz.repositorios.CatalogoRepositorio;
import com.example.modasluz.repositorios.RegistroVentaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class RegistroVentaService {

    private RegistroVentaRepositorio registroVentaRepositorio;
    private RegistroVentaMapper registroVentaMapper;
    private CatalogoRepositorio catalogoRepositorio;

    /**
     * Guarda un registro de venta o lo modifica si ya existe
     * @param registroVenta
     * @return
     */


    /**
     * Elimina un producto gracias a su id
     * @param id
     */
    public void eliminar (Integer id){
        registroVentaRepositorio.deleteById(id);
    }

    /**
     * Obtiene todos los productos
     * @return
     */
    public List<RegistroVenta> getAll(){
        List<RegistroVenta> lista = registroVentaRepositorio.findAll();
        for (RegistroVenta registroVenta : lista) {
            registroVenta = calcularPrecioVenta(registroVenta);
        }
        return lista;
    }

    /**
     * Obtiene un producto por su id
     * @param id
     * @return
     */
    public RegistroVenta getById(Integer id){
        return registroVentaRepositorio.findById(id).orElse(null);
    }

    public Set<RegistroVentaDTO> getRegistroVentaByPedidoId(Integer pedidoId) {
        Set<RegistroVenta> registros = registroVentaRepositorio.findByPedidoId(pedidoId);
        for (RegistroVenta registro : registros) {
            registro = calcularPrecioVenta(registro);
        }
        return registroVentaMapper.toDTO(registros);
    }

    public RegistroVenta calcularPrecioVenta(RegistroVenta registroVenta) {

        Optional<Catalogo> catalogo = catalogoRepositorio.findById(registroVenta.getProducto().getId());
        if (catalogo.isPresent()) {
            double precioProducto = catalogo.get().getPrecio();
            registroVenta.setPrecio_venta(precioProducto * registroVenta.getCantidad());
        } else {
            throw new RuntimeException("No se encontró el producto en el catálogo.");
        }
        return registroVenta;
    }

}
