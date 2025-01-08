package com.example.modasluz.dto;
import com.example.modasluz.modelos.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoPersonalizadoDTO {

    private Integer id_cliente;
    private Integer id_tipo_pago;
    private LocalDate fecha;
    private String codigo;
    private List<Integer> productos;
    private List<Integer> cantidades;

}
