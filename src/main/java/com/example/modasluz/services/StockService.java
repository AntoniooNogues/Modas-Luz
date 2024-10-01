package com.example.modasluz.services;

import com.example.modasluz.modelos.Stock;
import com.example.modasluz.repositorios.StockRepositorio;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StockService {

    private StockRepositorio stockRepositorio;

    /**
     * Guarda el stock de un producto o lo modifica si ya existe
     * @param stock
     * @return
     */

    public Stock guardar (Stock stock){
        return stockRepositorio.save(stock);
    }

    /**
     * Elimina un producto gracias a su id
     * @param id
     */
    public void eliminar (Integer id){
        stockRepositorio.deleteById(id);
    }

    /**
     * Obtiene todos los productos
     * @return
     */
    public List<Stock> getAll(){
        return stockRepositorio.findAll();
    }

    /**
     * Obtiene un producto por su id
     * @param id
     * @return
     */
    public Stock getById(Integer id){
        return stockRepositorio.findById(id).orElse(null);
    }

}
