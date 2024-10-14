package com.example.modasluz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductoDTO {

    private String nombre;
    private String descripcion;
    private String imagen;
    private Integer tipoProducto;


}
