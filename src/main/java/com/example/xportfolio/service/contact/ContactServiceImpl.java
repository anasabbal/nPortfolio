package com.example.xportfolio.service.contact;

import com.example.xportfolio.command.AddressCommand;
import com.example.xportfolio.command.ContactCommand;
import com.example.xportfolio.exception.BusinessException;
import com.example.xportfolio.exception.ExceptionPayloadFactory;
import com.example.xportfolio.model.Address;
import com.example.xportfolio.model.Contact;
import com.example.xportfolio.model.Writer;
import com.example.xportfolio.repository.AddressRepository;
import com.example.xportfolio.repository.ContactRepository;
import com.example.xportfolio.repository.WriterRepository;
import com.example.xportfolio.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class ContactServiceImpl implements ContactService{

    private final ContactRepository contactRepository;
    private final WriterRepository writerRepository;
    private final AddressRepository addressRepository;


    @Override
    public Contact addContactToWriter(final String writerId, final ContactCommand contactCommand){
        final Writer writer = writerRepository.findById(writerId)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.WRITER_NOT_FOUND.get()));

        log.info("Begin creating and adding contact with payload {} to writer with id {}", JSONUtil.toJSON(contactCommand), writer);
        final Contact contact = Contact.createContact(contactCommand);
        writer.setContact(contact);

        return contactRepository.save(contact);
    }
    @Override
    public Address addAddressToContactWithWriterId(String writerId, AddressCommand addressCommand){
        final Writer writer = writerRepository.findById(writerId)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.WRITER_NOT_FOUND.get()));
        final Contact contact = writer.getContact();

        final Address address = addressRepository.save(contact.linkToAddress(addressCommand));

        return address;
    }

    @Override
    public Contact updateContact(String contactId, ContactCommand contactCommand) {
        final Contact contact = getById(contactId);
        contact.updateContact(contactCommand);

        return contactRepository.save(contact);
    }

    @Override
    public Contact getById(String contactId) {
        log.info("Begin fetching contact with id {}", contactId);

        final Contact contact = contactRepository.findById(contactId).
                orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.CONTACT_NOT_FOUND.get()));

        return contact;
    }
}
