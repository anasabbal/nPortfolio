package com.example.xportfolio.mapper;


import com.example.xportfolio.dto.WriterDto;
import com.example.xportfolio.model.Writer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WriterMapper {
    WriterDto toWriterDto(Writer writer);
}