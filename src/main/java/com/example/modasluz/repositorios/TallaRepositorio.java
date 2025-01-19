package com.example.modasluz.repositorios;
import com.example.modasluz.modelos.Talla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TallaRepositorio extends JpaRepository<Talla, Integer> {

    Talla findByTipo(String tipo);

}
