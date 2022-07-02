package com.example.xportfolio.mapper;


import com.example.xportfolio.dto.LangDto;
import com.example.xportfolio.model.Lang;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LangMapper {
    LangDto toLangDto(Lang lang);
}
