package com.example.modasluz.mappers;
import com.example.modasluz.dto.ColorDTO;
import com.example.modasluz.modelos.Color;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ColorMapper {
    /**
     * Convierte una dto a una entity.
     * @param dto
     * @return
     */
    Color toEntity(ColorDTO dto);

    /**
     * Convierte una entity a DTO.
     * @param entity
     * @return
     */
    ColorDTO toDTO(Color entity);


    List<Color> toEntity(List<ColorDTO> dtos);


    List<ColorDTO> toDTO(List<Color> entities);

}
