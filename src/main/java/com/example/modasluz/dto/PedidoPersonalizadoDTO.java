package com.example.modasluz.dto;
import com.example.modasluz.modelos.Producto;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoPersonalizadoDTO {

    private Integer id_cliente;
    private Integer id_tipo_pago;
    private LocalDate fecha;
    private List<Integer> productos = new ArrayList<>();
    private List<Integer> cantidades = new ArrayList<>();

}
