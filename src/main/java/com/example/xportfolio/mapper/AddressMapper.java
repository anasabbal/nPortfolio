package com.example.xportfolio.mapper;


import com.example.xportfolio.dto.AddressDto;
import com.example.xportfolio.model.Address;
import org.mapstruct.Mapper;

@Mapper
public interface AddressMapper {
    AddressDto toAddressDto(Address address);
}
