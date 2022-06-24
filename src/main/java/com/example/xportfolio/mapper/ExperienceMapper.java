package com.example.xportfolio.mapper;


import com.example.xportfolio.dto.ExperienceDto;
import com.example.xportfolio.model.Experience;
import org.mapstruct.Mapper;

@Mapper
public interface ExperienceMapper {
    ExperienceDto toExperienceDto(Experience experience);
}
