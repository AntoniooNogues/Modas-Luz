package com.example.modasluz.repositorios;

import com.example.modasluz.modelos.Producto;
import com.example.modasluz.modelos.TipoProducto;
import com.example.modasluz.modelos.TipoProductoPrecio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProductoPrecioRepositorio extends JpaRepository<TipoProductoPrecio, Integer> {


}
