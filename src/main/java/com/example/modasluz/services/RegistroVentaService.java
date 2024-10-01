package com.example.modasluz.services;


import com.example.modasluz.modelos.RegistroVenta;
import com.example.modasluz.repositorios.RegistroVentaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegistroVentaService {

    private RegistroVentaRepositorio registroVentaRepositorio;

    /**
     * Guarda un registro de venta o lo modifica si ya existe
     * @param registroVenta
     * @return
     */

    public RegistroVenta registroVenta (RegistroVenta registroVenta){
        return registroVentaRepositorio.save(registroVenta);
    }

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
        return registroVentaRepositorio.findAll();
    }

    /**
     * Obtiene un producto por su id
     * @param id
     * @return
     */
    public RegistroVenta getById(Integer id){
        return registroVentaRepositorio.findById(id).orElse(null);
    }

}
