package com.example.modasluz.mappers;
import com.example.modasluz.dto.TallaDTO;
import com.example.modasluz.modelos.Talla;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TallaMapper {
    /**
     * Convierte una dto a una entity.
     * @param dto
     * @return
     */
    Talla toEntity(TallaDTO dto);

    /**
     * Convierte una entity a DTO.
     * @param entity
     * @return
     */
    TallaDTO toDTO(Talla entity);


    List<Talla> toEntity(List<TallaDTO> dtos);


    List<TallaDTO> toDTO(List<Talla> entities);

}
