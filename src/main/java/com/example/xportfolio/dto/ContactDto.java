package com.example.xportfolio.dto;

import com.example.xportfolio.model.Address;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapper;


@Getter
@Setter
public class ContactDto {
    private String id;
    private AddressDto address;
    private String email;
    private String phone;
    private String gmail_url;
    private String github_link;
}
