package com.example.modasluz.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoProductoPrecioDTO {

    private Long idProducto;
    private Long idTalla;
    private Long idColor;
    private Double precio;
}
