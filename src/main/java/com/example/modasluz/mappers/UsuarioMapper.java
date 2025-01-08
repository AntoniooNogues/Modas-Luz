package com.example.modasluz.mappers;

import com.example.modasluz.dto.*;
import com.example.modasluz.modelos.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO usuarioDTO);

    UsuarioDTO toDTONormal(Usuario usuario);

    UsuarioDTOPedidos toDTO(Usuario usuario);

    List<UsuarioDTO> toDTO(List<Usuario> usuarios);
    List<Usuario> toEntity(List<UsuarioDTO> usuarioDTOS);

    @Mapping(source = "pedidos", target = "pedidosDTO")
    UsuarioDTOPedidos toDTOPedidos(Usuario usuario);

    @Mapping(source = "tipo_pago", target = "tipo_pago")
    PedidoDTO toPedidoDTO(Pedido pedido);

    @Mapping(source = "tipo_metodo_pago", target = "tipo_metodo_pago")
    @Mapping(source = "tipo_estatus_pago", target = "tipo_estatus_pago")
    TipoPagoDTO toTipoPagoDTO(TipoPago tipoPago);

    @Mapping(source = "producto", target = "productoDTO")
    RegistroVentaDTO toRegistroVentaDTO(RegistroVenta registroVenta);

    ProductoDTO toProductoDTO(Producto producto);

    List<PedidoDTO> toPedidoDTOList(Set<Pedido> pedidos);
    Set<RegistroVentaDTO> toRegistroVentaDTOList(Set<RegistroVenta> registrosVentas);
}