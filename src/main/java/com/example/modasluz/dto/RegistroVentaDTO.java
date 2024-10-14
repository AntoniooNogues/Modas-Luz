package com.example.modasluz.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroVentaDTO {
    private Integer cantidd;
    private Double precioVenta;
    private Long idPedido;
    private Long idProducto;
}
