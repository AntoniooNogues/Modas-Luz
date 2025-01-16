package com.example.modasluz.mappers;
import com.example.modasluz.dto.*;
import com.example.modasluz.modelos.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CatalogoMapper {

    CatalogoDTO toDTO(Catalogo catalogo);
    Catalogo toEntity(CatalogoDTO catalogoDTO);

    @Mapping(target = "productoDTO", source = "producto")
    @Mapping(target = "tipoProductoDTO", source = "producto.tipoProducto")
    List<Catalogo> toEntity(List<CatalogoDTO> dtos);

    @Mapping(target = "productoDTO", source = "producto")
    @Mapping(target = "tipoProductoDTO", source = "producto.tipoProducto")
    List<CatalogoDTO> toDTO(List<Catalogo> entities);

    ProductoDTO toProductoDTO(Producto producto);
    Producto toProducto(ProductoDTO productoDTO);

    TipoProductoDTO toTipoProductoDTO(TipoProducto tipoProducto);
    TipoProducto toTipoProducto(TipoProductoDTO tipoProductoDTO);


}
