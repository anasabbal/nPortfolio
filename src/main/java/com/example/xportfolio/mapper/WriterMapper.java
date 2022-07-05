package com.example.xportfolio.mapper;


import com.example.xportfolio.dto.WriterDto;
import com.example.xportfolio.model.Writer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WriterMapper {
    WriterDto toWriterDto(Writer writer);

    static String to_Strin(byte[] value){
        String _new = new String(value);

        return _new;
    }
}