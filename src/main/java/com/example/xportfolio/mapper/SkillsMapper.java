package com.example.xportfolio.mapper;


import com.example.xportfolio.dto.SkillsDto;
import com.example.xportfolio.model.Skills;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillsMapper {
    SkillsDto toSkillsDto(Skills skills);
}
