package com.example.modasluz.repositorios;

import com.example.modasluz.modelos.Producto;
import com.example.modasluz.modelos.RegistroVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroVentaRepositorio extends JpaRepository<RegistroVenta, Integer> {


}
