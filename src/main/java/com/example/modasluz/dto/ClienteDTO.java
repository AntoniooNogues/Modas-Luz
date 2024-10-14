package com.example.modasluz.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private Integer codigoPostal;
}
