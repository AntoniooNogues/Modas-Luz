package com.example.modasluz.services;

import com.example.modasluz.modelos.Talla;
import com.example.modasluz.repositorios.TallaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TallaService {

    private TallaRepositorio tallaRepositorio;

    /**
     * Guarda una talla o lo modifica si ya existe
     * @param talla
     * @return
     */

    public Talla guardar (Talla talla){
        return tallaRepositorio.save(talla);
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
    public List<Talla> getAll(){
        return tallaRepositorio.findAll();
    }

    /**
     * Obtiene un producto por su id
     * @param id
     * @return
     */
    public Talla getById(Integer id){
        return tallaRepositorio.findById(id).orElse(null);
    }

}
