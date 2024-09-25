package com.example.modasluz.repositorios;

import com.example.modasluz.modelos.Color;
import com.example.modasluz.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepositorio extends JpaRepository<Color, Integer> {


}
