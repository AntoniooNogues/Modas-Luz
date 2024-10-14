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

    private MetodoPago metodoPago;
    private String detallesEfectivo;
    private EstatusPago estatusPago;
    private String referenciaPago;

}
