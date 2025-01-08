package com.example.modasluz.dto;
import com.example.modasluz.modelos.TipoPago;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private LocalDate fecha;
    private String codigo;
    private TipoPagoDTO tipo_pago;
    private Set<RegistroVentaDTO> registros;

}
