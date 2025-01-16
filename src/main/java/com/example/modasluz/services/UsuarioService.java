package com.example.modasluz.services;

import com.example.modasluz.dto.UsuarioDTO;
import com.example.modasluz.dto.UsuarioDTOPedidos;
import com.example.modasluz.dto.PedidoDTO;
import com.example.modasluz.mappers.UsuarioMapper;
import com.example.modasluz.modelos.Usuario;
import com.example.modasluz.repositorios.UsuarioRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
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

    public String eliminar (Integer id) throws Exception{
        Optional<Usuario> usuario = usuarioRepositorio.findById(id);
        if (!usuario.isPresent()){
            throw new Exception("No se ha encontrado un cliente con el id ingresado");
        }else{
            usuarioRepositorio.deleteById(id);
            return "Cliente eliminado correctamente";
        }
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

    @Transactional
    public UsuarioDTOPedidos getPedidosDeCliente(Integer clienteId) throws Exception {
        Optional<Usuario> cliente = usuarioRepositorio.findById(clienteId);
        if (!cliente.isPresent()){
            throw new Exception("No se ha encontrado un cliente con el id ingresado");
        }else{
            UsuarioDTOPedidos clienteDTO = usuarioMapper.toDTO(cliente);
            Set<PedidoDTO> pedidosDTO = clientePedidoService.getPedidosByClienteId(clienteId);
            if (pedidosDTO.isEmpty()){
                throw new Exception("El cliente no tiene pedidos asociados");
            }else{
                clienteDTO.setPedidosDTO(pedidosDTO);
                return clienteDTO;
            }
        }
    }
}
