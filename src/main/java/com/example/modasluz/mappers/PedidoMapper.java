package com.example.modasluz.mappers;

import com.example.modasluz.dto.PedidoDTO;
import com.example.modasluz.dto.RegistroVentaDTO;
import com.example.modasluz.modelos.Pedido;
import com.example.modasluz.modelos.RegistroVenta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    PedidoDTO toDTO(Pedido pedido);
    Pedido toEntity(PedidoDTO pedidoDTO);

    List<PedidoDTO> toDTO(List<Pedido> pedidos);
    List<Pedido> toEntity(List<PedidoDTO> pedidoDTOS);

    Set<PedidoDTO> toDTO(Set<Pedido> pedidos);
    Set<Pedido> toEntity(Set<PedidoDTO> pedidoDTOS);

    @Mapping(source = "producto", target = "productoDTO")
    Set<RegistroVentaDTO> toDTORegistro(Set<RegistroVenta> registrosVenta);
    @Mapping(source = "productoDTO", target = "producto")
    Set<RegistroVenta> toEntityRegistro(Set<RegistroVentaDTO> registrosVentaDTO);

    @Mapping(source = "producto", target = "productoDTO")
    RegistroVentaDTO toDTO(RegistroVenta registroVenta);

    @Mapping(source = "productoDTO", target = "producto")
    RegistroVenta toEntity(RegistroVentaDTO registroVentaDTO);
}