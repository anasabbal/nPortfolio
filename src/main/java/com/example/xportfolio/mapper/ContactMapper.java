package com.example.xportfolio.mapper;


import com.example.xportfolio.dto.ContactDto;
import com.example.xportfolio.model.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactDto toContactDto(Contact contact);
}
