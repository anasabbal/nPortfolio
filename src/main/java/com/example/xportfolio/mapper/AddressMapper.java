package com.example.xportfolio.mapper;


import com.example.xportfolio.dto.AddressDto;
import com.example.xportfolio.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDto toAddressDto(Address address);
}
