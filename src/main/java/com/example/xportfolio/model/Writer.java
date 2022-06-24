package com.example.xportfolio.model;


import com.example.xportfolio.command.AddressCommand;
import com.example.xportfolio.command.WriterCommand;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Writer extends AbstractEntity{


    private String firstName;
    private String lastName;
    private String pd_profile;

    @OneToOne
    private Contact contact;

    @OneToOne(cascade = CascadeType.ALL)
    private About about;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "writer")
    @JsonIgnore
    private Set<Formation> formations;

    @OneToMany(mappedBy = "writer", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Experience> experiences;

    @OneToOne
    private Lang lang;

    @OneToMany(mappedBy = "writer", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Skills> skills;

    public static Writer createOne(final WriterCommand writerCommand){
        final Writer writer = new Writer();

        writer.firstName = writerCommand.getFirstName();
        writer.lastName = writerCommand.getLastName();
        writer.pd_profile = writerCommand.getPd_profile();

        return writer;
    }
    public Address addToAddress(final AddressCommand addressCommand){
       final Address address = Address.createAddress(addressCommand);
       address.linkToWriter(this);

       return address;
    }
}
