package com.example.xportfolio.model;


import com.example.xportfolio.command.AddressCommand;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
public class Address extends AbstractEntity{

    private String street;
    private String city;
    private String country;

    @OneToOne(mappedBy = "contact")
    private Writer writer;

    public static Address createAddress(final AddressCommand addressCommand){
        final Address address = new Address();

        address.street = addressCommand.getStreet();
        address.city = addressCommand.getCity();
        address.country = addressCommand.getCountry();

        return address;
    }
    public void linkToWriter(Writer Writer){
        this.writer = writer;
    }
}
