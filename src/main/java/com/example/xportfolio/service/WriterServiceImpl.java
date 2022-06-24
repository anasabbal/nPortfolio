package com.example.xportfolio.service;


import com.example.xportfolio.command.AddressCommand;
import com.example.xportfolio.command.WriterCommand;
import com.example.xportfolio.dto.WriterDto;
import com.example.xportfolio.mapper.WriterMapper;
import com.example.xportfolio.model.Address;
import com.example.xportfolio.model.Contact;
import com.example.xportfolio.model.Writer;
import com.example.xportfolio.repository.AddressRepository;
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
        final Writer writer = writerRepository.findById(writerId).get();

        return writer;
    }

    @Override
    public Address addContactToWriter(String writerId, AddressCommand addressCommand) {
        final Writer writer = getById(writerId);
        log.info("Begin creating and adding address with payload {} to writer with id {}", JSONUtil.toJSON(addressCommand), writer);

        final Address address = addressRepository.save(writer.addToAddress(addressCommand));
        log.info("New address has been added successfully to writer with id {}", writer);

        return address;
    }
}
