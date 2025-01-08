package com.example.modasluz.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogoPersonalizadoDTO {

    private Integer id_producto;
    private String talla;
    private Integer cantidad;

}
