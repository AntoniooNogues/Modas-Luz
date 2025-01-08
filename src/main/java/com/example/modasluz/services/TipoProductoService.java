package com.example.modasluz.services;

import com.example.modasluz.dto.TipoProductoDTO;
import com.example.modasluz.mappers.TipoProductoMapper;
import com.example.modasluz.modelos.TipoProducto;
import com.example.modasluz.repositorios.TipoProductoRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TipoProductoService {

    private TipoProductoRepositorio tipoProductoRepositorio;

    private TipoProductoMapper tipoProductoMapper;

    /**
     * Guarda un producto o lo modifica si ya existe
     * @param tipoProductoDTO
     * @return
     */

    public TipoProducto guardar (TipoProductoDTO tipoProductoDTO){
        return tipoProductoRepositorio.save(tipoProductoMapper.toEntity(tipoProductoDTO));
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
    public List<TipoProductoDTO> getAll(){
        return tipoProductoMapper.toDTO(tipoProductoRepositorio.findAll());
    }

    /**
     * Obtiene un producto por su id
     * @param id
     * @return
     */
    public TipoProductoDTO getById(Integer id){
        return tipoProductoMapper.toDTO(tipoProductoRepositorio.findById(id).get());
    }

}
