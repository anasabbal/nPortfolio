package com.example.xportfolio.mapper;


import com.example.xportfolio.dto.FormationDto;
import com.example.xportfolio.model.Formation;
import org.mapstruct.Mapper;

@Mapper
public interface FormationMapper {
    FormationDto toFormationDto(Formation formation);
}
