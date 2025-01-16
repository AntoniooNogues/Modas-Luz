package com.example.modasluz.controladores;

import com.example.modasluz.dto.UsuarioDTO;
import com.example.modasluz.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class UsuarioController {

    private UsuarioService usuarioService;



    @GetMapping("/eliminar")
    public String eliminar(@RequestParam Integer id) throws Exception{
        return usuarioService.eliminar(id);
    }


    @GetMapping("/listar")
    public List<UsuarioDTO> getClientes() {
        return usuarioService.getAll();
    }

}
