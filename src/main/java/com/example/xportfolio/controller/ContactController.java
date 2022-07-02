package com.example.xportfolio.controller;

import com.example.xportfolio.command.AddressCommand;
import com.example.xportfolio.command.ContactCommand;
import com.example.xportfolio.model.Address;
import com.example.xportfolio.model.Contact;
import com.example.xportfolio.service.contact.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.example.xportfolio.cons.ResourcePath.*;

@RestController
@RequestMapping(V1+CONTACT)
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;


    @PostMapping("/{writerId}")
    public ResponseEntity<Contact> addContactToWrtier(@PathVariable("writerId") final String writerId,
                                                      @RequestBody final ContactCommand contactCommand){
        final Contact contact = contactService.addContactToWriter(writerId, contactCommand);

        return ResponseEntity.ok(contact);
    }
    @PostMapping(ADDRESS + "/{writerId}")
    public ResponseEntity<Address> addAddressToContactWithWriterId(@PathVariable("writerId") final String writerId,
                                                                   @RequestBody final AddressCommand addressCommand){
        final Address address = contactService.addAddressToContactWithWriterId(writerId, addressCommand);

        return ResponseEntity.ok(address);
    }
}
