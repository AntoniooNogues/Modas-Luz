package com.example.modasluz.repositorios;

import com.example.modasluz.modelos.Pedido;
import com.example.modasluz.modelos.Producto;
import com.example.modasluz.modelos.RegistroVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RegistroVentaRepositorio extends JpaRepository<RegistroVenta, Integer> {

    Set<RegistroVenta> findByPedidoId(Integer pedidoId);
}

