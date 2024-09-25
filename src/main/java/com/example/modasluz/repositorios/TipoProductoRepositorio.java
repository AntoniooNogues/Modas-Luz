package com.example.modasluz.repositorios;

import com.example.modasluz.modelos.Producto;
import com.example.modasluz.modelos.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProductoRepositorio extends JpaRepository<TipoProducto, Integer> {


}
