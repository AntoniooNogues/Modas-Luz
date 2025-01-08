package com.example.modasluz.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroVentaDTO {
    private Integer cantidad;
    private Double precio_venta;
    private ProductoDTO productoDTO;
}
