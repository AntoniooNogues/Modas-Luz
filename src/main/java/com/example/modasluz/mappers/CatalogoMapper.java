package com.example.modasluz.mappers;
import com.example.modasluz.dto.CatalogoDTO;
import com.example.modasluz.modelos.Catalogo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CatalogoMapper {
    /**
     * Convierte una dto a una entity.
     * @param dto
     * @return
     */
    Catalogo toEntity(CatalogoDTO dto);

    /**
     * Convierte una entity a DTO.
     * @param entity
     * @return
     */
    CatalogoDTO toDTO(Catalogo entity);


    List<Catalogo> toEntity(List<CatalogoDTO> dtos);


    List<CatalogoDTO> toDTO(List<Catalogo> entities);

}
