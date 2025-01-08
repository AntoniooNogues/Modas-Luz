package com.example.modasluz.services;

import com.example.modasluz.dto.UsuarioDTO;
import com.example.modasluz.dto.UsuarioDTOPedidos;
import com.example.modasluz.dto.PedidoDTO;
import com.example.modasluz.mappers.UsuarioMapper;
import com.example.modasluz.modelos.Usuario;
import com.example.modasluz.repositorios.UsuarioRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final ClientePedidoService clientePedidoService;
    private UsuarioRepositorio usuarioRepositorio;
    private UsuarioMapper usuarioMapper;


    public Usuario guardar (UsuarioDTO cliente){
        return usuarioRepositorio.save(usuarioMapper.toEntity(cliente));
    }

    public void eliminar (Integer id){
        usuarioRepositorio.deleteById(id);
    }

    public List<UsuarioDTO> getAll(){
        return usuarioMapper.toDTO(usuarioRepositorio.findAll());
    }

    public UsuarioDTO getById(Integer id){
        return usuarioMapper.toDTONormal(usuarioRepositorio.findById(id).orElse(null));
    }

    public Usuario getByIdCliente(Integer id){
        return usuarioRepositorio.findById(id).orElse(null);
    }

    public Usuario crearPedido (UsuarioDTO usuarioDTO){
        return usuarioRepositorio.save(usuarioMapper.toEntity(usuarioDTO));
    }

    public UsuarioDTOPedidos getPedidosDeCliente(Integer clienteId) {
        UsuarioDTOPedidos cliente = usuarioMapper.toDTO(usuarioRepositorio.findById(clienteId).orElse(null));
        Set<PedidoDTO> pedidosDTO = clientePedidoService.getPedidosByClienteId(clienteId);
        cliente.setPedidosDTO(pedidosDTO);
        return cliente;
    }

    public Usuario buscarUsuarioPorNombre(String username) {
        return usuarioRepositorio.findTopByUsername(username).orElse(null);
    }
}
