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
    public Object eliminar(@RequestParam Integer id) {
        try {
            if (usuarioService.getByIdCliente(id) != null) {
                if (usuarioService.getPedidosDeCliente(id).getPedidosDTO().isEmpty()) {
                    usuarioService.eliminar(id);
                    return "Cliente eliminado";
                } else {
                    return "No se puede eliminar el cliente porque tiene pedidos asociados";
                }
            }
        } catch (Exception e) {
            return "Error al eliminar el cliente";
        }
        return "No se ha encontrado un cliente con el id ingresado";
    }


    @GetMapping("/listar")
    public List<UsuarioDTO> getClientes() {
        return usuarioService.getAll();
    }

}
