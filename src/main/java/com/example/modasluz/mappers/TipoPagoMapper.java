package com.example.modasluz.mappers;

import com.example.modasluz.dto.TipoPagoDTO;
import com.example.modasluz.modelos.TipoPago;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TipoPagoMapper {


    TipoPagoDTO toDTO(TipoPago tipoPago);
    TipoPago toEntity(TipoPagoDTO tipoPagoDTO);

    List<TipoPagoDTO> toDTO(List<TipoPago> tipoPagos);
    List<TipoPago> toEntity(List<TipoPagoDTO> tipoPagoDTOS);

}
