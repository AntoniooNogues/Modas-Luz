package com.example.modasluz.dto;
import com.example.modasluz.modelos.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTOPedidos {
    private String nombre;
    private String apellidos;
    private String dni;
    private String correo_electronico;
    private Set<PedidoDTO> pedidosDTO;

    public UsuarioDTOPedidos(Usuario usuario, Set<PedidoDTO> pedidosDTO) {
        this.nombre = usuario.getNombre();
        this.apellidos = usuario.getApellidos();
        this.dni = usuario.getDni();
        this.correo_electronico = usuario.getCorreo_electronico();
        this.pedidosDTO = pedidosDTO;
    }
}
