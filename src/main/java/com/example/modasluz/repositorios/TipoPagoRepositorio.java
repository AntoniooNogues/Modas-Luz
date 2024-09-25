package com.example.modasluz.repositorios;

import com.example.modasluz.modelos.Producto;
import com.example.modasluz.modelos.TipoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPagoRepositorio extends JpaRepository<TipoPago, Integer> {


}
