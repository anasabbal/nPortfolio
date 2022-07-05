package com.example.xportfolio.model;



import com.example.xportfolio.command.AddressCommand;
import com.example.xportfolio.command.ContactCommand;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.type.StringNVarcharType;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Contact extends AbstractEntity{

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    private String email;
    private String phone;
    private String gmail_url;
    private String github_link;
    private String password;


    public static Contact createContact(final ContactCommand contactCommand){
        final Contact contact = new Contact();
        contact.email = contactCommand.getEmail();
        contact.phone = contactCommand.getPhone();
        contact.gmail_url = contactCommand.getGmail_url();
        contact.github_link = contactCommand.getGithub_link();

        return contact;
    }
    public void updateContact(final ContactCommand contactCommand){
        this.email = contactCommand.getEmail();
        this.phone = contactCommand.getPhone();
        this.gmail_url = contactCommand.getGmail_url();
        this.github_link = contactCommand.getGithub_link();
    }
    public Address linkToAddress(final AddressCommand addressCommand){
        final Address address1 = Address.createAddress(addressCommand);

        return this.address = address1;
    }
}
