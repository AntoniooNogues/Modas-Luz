package com.example.modasluz.services;

import com.example.modasluz.modelos.Color;
import com.example.modasluz.repositorios.ColorRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorService {

    private ColorRepositorio colorRepositorio;

    /**
     * Guarda un color o lo modifica si ya existe
     * @param color
     * @return
     */

    public Color guardar (Color color){
        return colorRepositorio.save(color);
    }

    /**
     * Elimina un producto gracias a su id
     * @param id
     */
    public void eliminar (Integer id){
        colorRepositorio.deleteById(id);
    }

    /**
     * Obtiene todos los productos
     * @return
     */
    public List<Color> getAll(){
        return colorRepositorio.findAll();
    }

    /**
     * Obtiene un producto por su id
     * @param id
     * @return
     */
    public Color getById(Integer id){
        return colorRepositorio.findById(id).orElse(null);
    }

}
