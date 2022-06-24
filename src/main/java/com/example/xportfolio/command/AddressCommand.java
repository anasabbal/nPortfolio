package com.example.xportfolio.command;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressCommand {
    private String street;
    private String city;
    private String country;
}
