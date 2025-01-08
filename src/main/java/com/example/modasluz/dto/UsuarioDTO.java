package com.example.modasluz.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private String nombre;
    private String apellidos;
    private String dni;
    private String correo_electronico;
    private String direccion;
    private Integer codigo_postal;
}
