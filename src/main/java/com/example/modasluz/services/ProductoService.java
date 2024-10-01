package com.example.modasluz.services;

import com.example.modasluz.modelos.Producto;
import com.example.modasluz.repositorios.ProductoRepositorio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoService {

    private ProductoRepositorio productoRepositorio;

    /**
     * Guarda un producto o lo modifica si ya existe
     * @param producto
     * @return
     */

    public Producto guardar (Producto producto){
        return productoRepositorio.save(producto);
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
    public List<Producto> getAll(){
        return productoRepositorio.findAll();
    }

    /**
     * Obtiene un producto por su id
     * @param id
     * @return
     */
    public Producto getById(Integer id){
        return productoRepositorio.findById(id).orElse(null);
    }

}
