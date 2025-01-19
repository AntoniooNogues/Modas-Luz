package com.example.modasluz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductoDTO {

    private TipoProductoDTO tipoProducto;
    private String nombre;
    private String descripcion;
    private String imagen;

    public ProductoDTO(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;

    }
}
