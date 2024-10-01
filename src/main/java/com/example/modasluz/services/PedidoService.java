package com.example.modasluz.services;

import com.example.modasluz.modelos.Pedido;
import com.example.modasluz.repositorios.PedidoRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {

    private PedidoRepositorio pedidoRepositorio;

    /**
     * Guarda un pedido o lo modifica si ya existe
     * @param pedido
     * @return
     */

    public Pedido guardar (Pedido pedido){
        return pedidoRepositorio.save(pedido);
    }

    /**
     * Elimina un producto gracias a su id
     * @param id
     */
    public void eliminar (Integer id){
        pedidoRepositorio.deleteById(id);
    }

    /**
     * Obtiene todos los productos
     * @return
     */
    public List<Pedido> getAll(){
        return pedidoRepositorio.findAll();
    }

    /**
     * Obtiene un producto por su id
     * @param id
     * @return
     */
    public Pedido getById(Integer id){
        return pedidoRepositorio.findById(id).orElse(null);
    }

}
