package com.example.xportfolio.model;



import com.example.xportfolio.command.AddressCommand;
import com.example.xportfolio.command.ContactCommand;
import lombok.Data;
import org.hibernate.type.StringNVarcharType;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
public class Contact extends AbstractEntity{

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private String email;
    private String phone;
    private String gmail_url;
    private String github_link;

    @OneToOne(optional = false)
    private Writer writer;


    public static Contact createContact(final ContactCommand contactCommand){
        final Contact contact = new Contact();
        contact.email = contactCommand.getEmail();
        contact.phone = contactCommand.getPhone();
        contact.gmail_url = contactCommand.getGmail_url();
        contact.github_link = contactCommand.getGithub_link();

        return contact;
    }
    public void linkToWriter(Writer writer){
        this.writer = writer;
    }
    public Address linkToAddress(final AddressCommand addressCommand){
        final Address address1 = Address.createAddress(addressCommand);

        return this.address = address1;
    }
}
