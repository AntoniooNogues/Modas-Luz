package com.example.modasluz.services;

import com.example.modasluz.modelos.TipoProducto;
import com.example.modasluz.repositorios.TipoProductoRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TipoProductoService {

    private TipoProductoRepositorio tipoProductoRepositorio;

    /**
     * Guarda un producto o lo modifica si ya existe
     * @param tipoProducto
     * @return
     */

    public TipoProducto guardar (TipoProducto tipoProducto){
        return tipoProductoRepositorio.save(tipoProducto);
    }

    /**
     * Elimina un producto gracias a su id
     * @param id
     */
    public void eliminar (Integer id){
        tipoProductoRepositorio.deleteById(id);
    }

    /**
     * Obtiene todos los productos
     * @return
     */
    public List<TipoProducto> getAll(){
        return tipoProductoRepositorio.findAll();
    }

    /**
     * Obtiene un producto por su id
     * @param id
     * @return
     */
    public TipoProducto getById(Integer id){
        return tipoProductoRepositorio.findById(id).orElse(null);
    }

}
