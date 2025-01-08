package com.example.modasluz.services;

import com.example.modasluz.dto.TallaDTO;
import com.example.modasluz.mappers.TallaMapper;
import com.example.modasluz.modelos.Talla;
import com.example.modasluz.repositorios.TallaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TallaService {

    private TallaRepositorio tallaRepositorio;

    private TallaMapper tallaMapper;

    /**
     * Guarda una talla o lo modifica si ya existe
     * @param talla
     * @return
     */

    public Talla guardar (TallaDTO talla){
        return tallaRepositorio.save(tallaMapper.toEntity(talla));
    }

    /**
     * Elimina un producto gracias a su id
     * @param id
     */
    public void eliminar (Integer id){
        tallaRepositorio.deleteById(id);
    }

    /**
     * Obtiene todos los productos
     * @return
     */
    public List<TallaDTO> getAll(){
        return tallaMapper.toDTO(tallaRepositorio.findAll());
    }

    /**
     * Obtiene un producto por su id
     * @param id
     * @return
     */
    public TallaDTO getById(Integer id){
        return tallaMapper.toDTO(tallaRepositorio.findById(id).orElse(null));
    }

}
