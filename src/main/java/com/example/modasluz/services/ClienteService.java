package com.example.modasluz.services;

import com.example.modasluz.modelos.Catalogo;
import com.example.modasluz.modelos.Cliente;
import com.example.modasluz.repositorios.CatalogoRepositorio;
import com.example.modasluz.repositorios.ClienteRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepositorio clienteRepositorio;

    /**
     * Guarda un cliente o lo modifica si ya existe
     * @param cliente
     * @return
     */

    public Cliente guardar (Cliente cliente){
        return clienteRepositorio.save(cliente);
    }

    /**
     * Elimina un producto gracias a su id
     * @param id
     */
    public void eliminar (Integer id){
        clienteRepositorio.deleteById(id);
    }

    /**
     * Obtiene todos los productos
     * @return
     */
    public List<Cliente> getAll(){
        return clienteRepositorio.findAll();
    }

    /**
     * Obtiene un producto por su id
     * @param id
     * @return
     */
    public Cliente getById(Integer id){
        return clienteRepositorio.findById(id).orElse(null);
    }

}
