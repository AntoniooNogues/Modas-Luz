package com.example.modasluz.mappers;

import com.example.modasluz.dto.*;
import com.example.modasluz.modelos.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface CatalogoMapper {

    @Mapping(target = "producto", source = "producto")
    @Mapping(target = "talla", source = "talla")
    @Mapping(target = "color", source = "color")
    Catalogo toEntity(CatalogoDTO catalogoDTO);

    @Mapping(target = "producto", source = "producto")
    @Mapping(target = "talla", source = "talla")
    @Mapping(target = "color", source = "color")
    CatalogoDTO toDTO(Catalogo catalogo);

    List<Catalogo> toEntity(List<CatalogoDTO> dtos);

    List<CatalogoDTO> toDTO(List<Catalogo> entities);

    ProductoDTO toProductoDTO(Producto producto);
    Producto toProducto(ProductoDTO productoDTO);

    TallaDTO toTallaDTO(Talla talla);
    Talla toTalla(TallaDTO tallaDTO);

    ColorDTO toColorDTO(Color color);
    Color toColor(ColorDTO colorDTO);
}