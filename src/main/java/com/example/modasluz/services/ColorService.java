package com.example.modasluz.services;

import com.example.modasluz.dto.ColorDTO;
import com.example.modasluz.mappers.ColorMapper;
import com.example.modasluz.modelos.Color;
import com.example.modasluz.repositorios.ColorRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorService {

    private ColorRepositorio colorRepositorio;
    private ColorMapper colorMapper;

    /**
     * Guarda un color o lo modifica si ya existe
     * @param color
     * @return
     */

    public Color guardar (ColorDTO color){
        return colorRepositorio.save(colorMapper.toEntity(color));
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
    public List<ColorDTO> getAll(){
        return colorMapper.toDTO(colorRepositorio.findAll());
    }

    /**
     * Obtiene un producto por su id
     * @param id
     * @return
     */
    public ColorDTO getById(Integer id){
        return colorMapper.toDTO(colorRepositorio.findById(id).orElse(null));
    }

}
