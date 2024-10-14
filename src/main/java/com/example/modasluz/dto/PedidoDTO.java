package com.example.modasluz.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
    private LocalDate fecha;
    private String codigo;
    private Long idCliente;
    private Long idTipoPago;
}
