package com.example.modasluz.services;

import com.example.modasluz.modelos.Catalogo;
import com.example.modasluz.modelos.TipoPago;
import com.example.modasluz.repositorios.CatalogoRepositorio;
import com.example.modasluz.repositorios.TipoPagoRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatalogoService {

    private CatalogoRepositorio catalogoRepositorio;

    /**
     * Guarda un catalogo o lo modifica si ya existe
     * @param catalogo
     * @return
     */

    public Catalogo guardar (Catalogo catalogo){
        return catalogoRepositorio.save(catalogo);
    }

    /**
     * Elimina un producto gracias a su id
     * @param id
     */
    public void eliminar (Integer id){
        catalogoRepositorio.deleteById(id);
    }

    /**
     * Obtiene todos los productos
     * @return
     */
    public List<Catalogo> getAll(){
        return catalogoRepositorio.findAll();
    }

    /**
     * Obtiene un producto por su id
     * @param id
     * @return
     */
    public Catalogo getById(Integer id){
        return catalogoRepositorio.findById(id).orElse(null);
    }

}
