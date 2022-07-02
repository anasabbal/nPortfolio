package com.example.xportfolio.service.writer;

import com.example.xportfolio.command.AddressCommand;
import com.example.xportfolio.command.ContactCommand;
import com.example.xportfolio.command.FormationCommand;
import com.example.xportfolio.command.WriterCommand;
import com.example.xportfolio.dto.WriterDto;
import com.example.xportfolio.model.Address;
import com.example.xportfolio.model.Contact;
import com.example.xportfolio.model.Formation;
import com.example.xportfolio.model.Writer;
import org.springframework.data.convert.WritingConverter;

public interface WriterService {

    Writer createOne(WriterCommand writerCommand);
    Writer getById(String writerId);

}