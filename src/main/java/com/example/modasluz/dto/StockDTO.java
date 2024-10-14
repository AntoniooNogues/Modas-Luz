package com.example.modasluz.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {

    private Integer cantidad;
    private Long idProducto;
    private Long idTalla;
}
