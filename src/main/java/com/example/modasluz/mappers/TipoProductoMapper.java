package com.example.modasluz.mappers;
import com.example.modasluz.dto.TallaDTO;
import com.example.modasluz.dto.TipoProductoDTO;
import com.example.modasluz.modelos.Talla;
import com.example.modasluz.modelos.TipoProducto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TipoProductoMapper {

    TipoProducto toEntity(TipoProductoDTO dto);
    TipoProductoDTO toDTO(TipoProducto entity);

    List<TipoProducto> toEntity(List<TipoProductoDTO> dtos);
    List<TipoProductoDTO> toDTO(List<TipoProducto> entities);

}
