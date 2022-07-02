package com.example.xportfolio.service.contact;

import com.example.xportfolio.command.AddressCommand;
import com.example.xportfolio.command.ContactCommand;
import com.example.xportfolio.model.Address;
import com.example.xportfolio.model.Contact;

public interface ContactService {

    Contact addContactToWriter(final String writerId, final ContactCommand contactCommand);
    Address addAddressToContactWithWriterId(String writerId, AddressCommand addressCommand);

    Contact updateContact(String contactId, final ContactCommand contactCommand);

    Contact getById(String contactId);
}
