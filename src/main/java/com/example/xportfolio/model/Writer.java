package com.example.xportfolio.model;


import com.example.xportfolio.command.AboutCommand;
import com.example.xportfolio.command.AddressCommand;
import com.example.xportfolio.command.ContactCommand;
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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "writer")
    private Contact contact;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private About about;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "writer")
    @JsonIgnore
    private Set<Formation> formations;

    @OneToMany(mappedBy = "writer", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Experience> experiences;

    @OneToOne
    private Lang lang;

    @OneToMany(mappedBy = "writer", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Skills> skills;

    public static Writer createOne(final WriterCommand writerCommand){
        final Writer writer = new Writer();

        writer.firstName = writerCommand.getFirstName();
        writer.lastName = writerCommand.getLastName();
        writer.pd_profile = writerCommand.getPd_profile();

        return writer;
    }
    public Contact addToContact(final ContactCommand contactCommand){
       final Contact contact1 = Contact.createContact(contactCommand);
       contact1.linkToWriter(this);

       return contact1;
    }
    public About addAboutToWriter(final AboutCommand aboutCommand){
        final About about1 = About.createAbout(aboutCommand);

        about1.linkToWriter(this);

        return about1;
    }
}
