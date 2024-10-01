package com.example.modasluz.services;

import com.example.modasluz.modelos.TipoProductoPrecio;
import com.example.modasluz.repositorios.TipoProductoPrecioRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TipoProductoPrecioService {

    private TipoProductoPrecioRepositorio tipoProductoPrecioRepositorio;

    /**
     * Guarda un tipoProductoPrecio o lo modifica si ya existe
     * @param tipoProductoPrecio
     * @return
     */

    public TipoProductoPrecio guardar (TipoProductoPrecio tipoProductoPrecio){
        return tipoProductoPrecioRepositorio.save(tipoProductoPrecio);
    }

    /**
     * Elimina un producto gracias a su id
     * @param id
     */
    public void eliminar (Integer id){
        tipoProductoPrecioRepositorio.deleteById(id);
    }

    /**
     * Obtiene todos los productos
     * @return
     */
    public List<TipoProductoPrecio> getAll(){
        return tipoProductoPrecioRepositorio.findAll();
    }

    /**
     * Obtiene un producto por su id
     * @param id
     * @return
     */
    public TipoProductoPrecio getById(Integer id){
        return tipoProductoPrecioRepositorio.findById(id).orElse(null);
    }

}
