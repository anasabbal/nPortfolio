package com.example.xportfolio.service;


import com.example.xportfolio.command.AddressCommand;
import com.example.xportfolio.command.ContactCommand;
import com.example.xportfolio.command.WriterCommand;
import com.example.xportfolio.dto.WriterDto;
import com.example.xportfolio.mapper.WriterMapper;
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

import java.io.File;

@Service
@RequiredArgsConstructor
@Slf4j
public class WriterServiceImpl implements WriterService{

    private final WriterRepository writerRepository;
    private final AddressRepository addressRepository;
    private final ContactRepository contactRepository;

    @Override
    public Writer createOne(WriterCommand writerCommand) {
        log.info("Begin creating writer with payload {}", JSONUtil.toJSON(writerCommand));
        writerCommand.validate();

        final Writer writer = writerRepository.save(Writer.createOne(writerCommand));
        log.info("Creating writer with payload {} Done !", JSONUtil.toJSON(writerCommand));

        return writer;
    }

    @Override
    public Writer getById(String writerId) {
        log.info("Begin fetching writer with id {}", writerId);
        final Writer writer = writerRepository.findById(writerId).orElseThrow();

        return writer;
    }

    @Override
    public Contact addContactToWriter(final String writerId, final ContactCommand contactCommand){
        final Writer writer = getById(writerId);
        log.info("Begin creating and adding contact with payload {} to writer with id {}", JSONUtil.toJSON(contactCommand), writer);
        final Contact contact = contactRepository.save(writer.addToContact(contactCommand));

        return contact;
    }
    @Override
    public Address addAddressToContactWithWriterId(String writerId, AddressCommand addressCommand){
        final Writer writer = getById(writerId);
        final Contact contact = writer.getContact();

        final Address address = addressRepository.save(contact.linkToAddress(addressCommand));

        return address;

    }
}
