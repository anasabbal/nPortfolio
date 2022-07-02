package com.example.xportfolio.mapper;


import com.example.xportfolio.dto.AboutDto;
import com.example.xportfolio.model.About;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AboutMapper {
    AboutDto toAboutDto(About about);
}
