package com.example.modasluz.dto;
import com.example.modasluz.enums.EstatusPago;
import com.example.modasluz.enums.MetodoPago;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoPagoDTO {

    //Enumerado tipo numero a string
    private MetodoPago tipo_metodo_pago;
    //Enumerado tipo numero a string
    private EstatusPago tipo_estatus_pago;

    private String referencia_pago;

}
