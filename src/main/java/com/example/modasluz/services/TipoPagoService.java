package com.example.modasluz.services;

import com.example.modasluz.modelos.Producto;
import com.example.modasluz.modelos.TipoPago;
import com.example.modasluz.repositorios.ProductoRepositorio;
import com.example.modasluz.repositorios.TipoPagoRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TipoPagoService {

    private TipoPagoRepositorio tipoPagoRepositorio;

    /**
     * Guarda un tipo de pago o lo modifica si ya existe
     * @param tipoPago
     * @return
     */

    public TipoPago guardar (TipoPago tipoPago){
        return tipoPagoRepositorio.save(tipoPago);
    }

    /**
     * Elimina un producto gracias a su id
     * @param id
     */
    public void eliminar (Integer id){
        tipoPagoRepositorio.deleteById(id);
    }

    /**
     * Obtiene todos los productos
     * @return
     */
    public List<TipoPago> getAll(){
        return tipoPagoRepositorio.findAll();
    }

    /**
     * Obtiene un producto por su id
     * @param id
     * @return
     */
    public TipoPago getById(Integer id){
        return tipoPagoRepositorio.findById(id).orElse(null);
    }

}
