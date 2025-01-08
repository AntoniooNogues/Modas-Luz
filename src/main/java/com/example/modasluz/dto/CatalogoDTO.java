package com.example.modasluz.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogoDTO {

    private ProductoDTO producto;
    private TallaDTO talla;
    private ColorDTO color;
    private Integer cantidad;
    private Double precio;
}
