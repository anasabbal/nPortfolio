package com.example.xportfolio.model;


import com.example.xportfolio.command.AddressCommand;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Address extends AbstractEntity{

    private String street;
    private String city;
    private String country;


    public static Address createAddress(final AddressCommand addressCommand){
        final Address address = new Address();

        address.street = addressCommand.getStreet();
        address.city = addressCommand.getCity();
        address.country = addressCommand.getCountry();

        return address;
    }
    public void update(final AddressCommand addressCommand){
        this.street = addressCommand.getStreet();
        this.city = addressCommand.getCity();
        this.country = addressCommand.getCountry();
    }
}
