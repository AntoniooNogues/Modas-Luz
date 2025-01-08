package com.example.modasluz.mappers;

import com.example.modasluz.dto.RegistroVentaDTO;
import com.example.modasluz.modelos.RegistroVenta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface RegistroVentaMapper {

    RegistroVentaMapper INSTANCE = Mappers.getMapper(RegistroVentaMapper.class);

    @Mapping(source = "producto", target = "productoDTO")
    RegistroVentaDTO toDTO(RegistroVenta registroVenta);
    @Mapping(source = "productoDTO", target = "producto")
    RegistroVenta toEntity(RegistroVentaDTO registroVentaDTO);

    List<RegistroVentaDTO> toDTO(List<RegistroVenta> registrosVenta);
    List<RegistroVenta> toEntity(List<RegistroVentaDTO> registrosVentaDTO);

    @Mapping(source = "producto", target = "productoDTO")
    Set<RegistroVentaDTO> toDTO(Set<RegistroVenta> registrosVenta);
    @Mapping(source = "productoDTO", target = "producto")
    Set<RegistroVenta> toEntity(Set<RegistroVentaDTO> registrosVentaDTO);
}