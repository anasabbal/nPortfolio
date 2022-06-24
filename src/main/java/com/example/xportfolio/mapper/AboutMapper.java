package com.example.xportfolio.mapper;


import com.example.xportfolio.dto.AboutDto;
import com.example.xportfolio.model.About;
import org.mapstruct.Mapper;

@Mapper
public interface AboutMapper {
    AboutDto toAboutDto(About about);
}
