package com.example.modasluz.mappers;

import com.example.modasluz.dto.*;
import com.example.modasluz.modelos.*;
import com.example.modasluz.repositorios.UsuarioRepositorio;
import com.example.modasluz.services.ClientePedidoService;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Mappers {

    private final UsuarioRepositorio usuarioRepositorio;

    public Mappers(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public TallaDTO toDTO(Talla entity) {
        TallaDTO dto = new TallaDTO();
        dto.setTipo(entity.getTipo());
        return dto;
    }

    public TipoProductoDTO toDTO(TipoProducto entity) {
        TipoProductoDTO dto = new TipoProductoDTO();
        dto.setNombre(entity.getNombre());
        return dto;
    }

    public ProductoDTO toDTO(Producto entity) {
        ProductoDTO dto = new ProductoDTO();
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        dto.setImagen(entity.getImagen());
        dto.setTipoProducto(toDTO(entity.getTipoProducto()));
        return dto;
    }

    public ColorDTO toDTO(Color entity) {
        ColorDTO dto = new ColorDTO();
        dto.setNombre(entity.getNombre());
        return dto;
    }

    public CatalogoDTO toDTO(Catalogo entity) {
        CatalogoDTO dto = new CatalogoDTO();
        dto.setProducto(toDTO(entity.getProducto()));
        dto.setTalla(toDTO(entity.getTalla()));
        dto.setColor(toDTO(entity.getColor()));
        dto.setCantidad(entity.getCantidad());
        dto.setPrecio(entity.getPrecio());
        return dto;
    }

    public List<CatalogoDTO> toDTO(List<Catalogo> entity) {
        List<CatalogoDTO> dtos = new ArrayList<>();
        for (Catalogo catalogo : entity) {
            dtos.add(toDTO(catalogo));
        }
        return dtos;
    }

    public UsuarioDTOPedidos toDTO(Optional<Usuario> entity) {
        UsuarioDTOPedidos dto = new UsuarioDTOPedidos();
        if (entity.isPresent()) {
            Usuario usuario = entity.get();
            dto.setNombre(usuario.getNombre());
            dto.setApellidos(usuario.getApellidos());
            dto.setDni(usuario.getDni());
            dto.setCorreo_electronico(usuario.getCorreo_electronico());
        }
        dto.setPedidosDTO(new HashSet<PedidoDTO>());
        return dto;
    }

    public TipoPagoDTO toDTO (TipoPago entity) {
        TipoPagoDTO dto = new TipoPagoDTO();
       dto.setReferencia_pago(entity.getReferencia_pago());
       dto.setTipo_estatus_pago(entity.getTipo_estatus_pago());
       dto.setTipo_metodo_pago(entity.getTipo_metodo_pago());
        return dto;
    }

    public PedidoDTO toDTO(Pedido entity) {
        PedidoDTO dto = new PedidoDTO();
        dto.setCodigo(entity.getCodigo());
        dto.setFecha(entity.getFecha());
        dto.setTipo_pago(toDTO(entity.getTipo_pago()));
        dto.setRegistros(new HashSet<RegistroVentaDTO>());
        return dto;
    }

    public Set<PedidoDTO> toDTO(Set<Pedido> entity) {
        Set<PedidoDTO> dtos = new HashSet<>();
        for (Pedido pedido : entity) {
            dtos.add(toDTO(pedido));
        }
        return dtos;
    }
}
