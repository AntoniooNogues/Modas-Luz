package com.example.modasluz.controladores;

import com.example.modasluz.modelos.Cliente;
import com.example.modasluz.modelos.Color;
import com.example.modasluz.services.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {

    private ClienteService clienteService;

    @GetMapping("/listar")
    public List<Cliente> getCliente(){
        List<Cliente> lista= clienteService.getAll();
        return lista;
    }

    @GetMapping()
    public Cliente getClienteById(@RequestParam Integer id){
        Cliente cliente= clienteService.getById(id);
        return cliente;
    }

    @GetMapping("/{id}")
    public Cliente getClienteByIdPath(@PathVariable Integer id){
        Cliente cliente= clienteService.getById(id);
        return cliente;
    }

    @PostMapping()
    public Cliente guardarCliente(@RequestBody Cliente catalogo){
        Cliente cliente = clienteService.guardar(catalogo);
        return cliente;
    }

    @DeleteMapping()
    public String eliminarCliente(@RequestParam Integer id){
        Cliente cliente = clienteService.getById(id);
        String mensaje = "";
        if (cliente == null) {
            mensaje = "El perfil con el id indicado no existe ";
        }
        try {
            clienteService.eliminar(id);
            cliente = clienteService.getById(id);
            if (cliente != null) {
                mensaje = ("No se ha podido eliminar el catalogo");
            }
        } catch (Exception e) {
            mensaje = "No se ha podido eliminar el catalogo";
        }
        return mensaje;
    }
}
