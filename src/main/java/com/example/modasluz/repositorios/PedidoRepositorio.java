package com.example.modasluz.repositorios;

import com.example.modasluz.dto.PedidoDTO;
import com.example.modasluz.modelos.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {

    Set<Pedido> findByClienteId(Integer clienteId);

    Pedido findTopByOrderByIdDesc();
}
