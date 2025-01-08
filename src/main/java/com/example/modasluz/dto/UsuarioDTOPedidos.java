package com.example.modasluz.dto;
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
}
