package com.example.modasluz.mappers;
import com.example.modasluz.dto.ProductoDTO;
import com.example.modasluz.modelos.Producto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductoMapper {
    /**
     * Convierte una dto a una entity.
     * @param dto
     * @return
     */
    Producto toEntity(ProductoDTO dto);

    /**
     * Convierte una entity a DTO.
     * @param entity
     * @return
     */

    ProductoDTO toDTO(Producto entity);


    List<Producto> toEntity(List<ProductoDTO> dtos);


    List<ProductoDTO> toDTO(List<Producto> entities);

}
