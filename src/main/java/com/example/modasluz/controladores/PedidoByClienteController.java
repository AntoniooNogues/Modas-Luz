package com.example.modasluz.controladores;

import com.example.modasluz.dto.UsuarioDTOPedidos;
import com.example.modasluz.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidosbycliente")
@AllArgsConstructor
public class PedidoByClienteController {

    private UsuarioService usuarioService;

    @GetMapping("")
    public UsuarioDTOPedidos getPedidosCliente(@RequestParam Integer id) throws Exception {
        return usuarioService.getPedidosDeCliente(id);
    }

}
