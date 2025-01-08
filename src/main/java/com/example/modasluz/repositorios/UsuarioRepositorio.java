package com.example.modasluz.repositorios;

import com.example.modasluz.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {


    Optional<Usuario> findTopByUsername(String username);
}
