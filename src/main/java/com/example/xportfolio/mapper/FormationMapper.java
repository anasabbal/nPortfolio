package com.example.xportfolio.mapper;


import com.example.xportfolio.dto.FormationDto;
import com.example.xportfolio.model.Formation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FormationMapper {
    FormationDto toFormationDto(Formation formation);
}
