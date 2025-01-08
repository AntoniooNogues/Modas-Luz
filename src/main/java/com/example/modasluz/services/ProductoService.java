package com.example.modasluz.services;

import com.example.modasluz.dto.ProductoDTO;
import com.example.modasluz.mappers.ProductoMapper;
import com.example.modasluz.modelos.Producto;
import com.example.modasluz.modelos.TipoProducto;
import com.example.modasluz.repositorios.ProductoRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoService {

    private ProductoRepositorio productoRepositorio;
    private ProductoMapper productoMapper;
    private TipoProductoService tipoProductoService;

    /**
     * Guarda un producto o lo modifica si ya existe
     * @param producto
     * @return
     */

    public Producto guardar (ProductoDTO producto){
        return productoRepositorio.save(productoMapper.toEntity(producto));
    }

    /**
     * Elimina un producto gracias a su id
     * @param id
     */
    public void eliminar (Integer id){
        productoRepositorio.deleteById(id);
    }

    /**
     * Obtiene todos los productos
     * @return
     */
    public List<ProductoDTO> getAll(){
        return productoMapper.toDTO(productoRepositorio.findAll());
    }

    /**
     * Obtiene un producto por su id
     * @param id
     * @return
     */
    public ProductoDTO getById(Integer id){
        return productoMapper.toDTO(productoRepositorio.findById(id).orElse(null));
    }

    public Producto getByIdNormal(Integer id){
        return productoRepositorio.findById(id).orElse(null);
    }

}
