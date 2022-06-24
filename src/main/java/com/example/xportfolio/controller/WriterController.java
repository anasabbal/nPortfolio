package com.example.xportfolio.controller;


import com.example.xportfolio.command.AddressCommand;
import com.example.xportfolio.command.WriterCommand;
import com.example.xportfolio.dto.WriterDto;
import com.example.xportfolio.mapper.WriterMapper;
import com.example.xportfolio.model.Address;
import com.example.xportfolio.model.Writer;
import com.example.xportfolio.service.WriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/writer")
@RequiredArgsConstructor
public class WriterController {

    private final WriterService writerService;
    private final WriterMapper writerMapper;

    @PostMapping
    public ResponseEntity<Writer> createWriter(@RequestBody WriterCommand writerCommand){
        final Writer writer = writerService.createOne(writerCommand);

        return ResponseEntity.ok(writer);
    }
    @GetMapping("/{writerId}")
    public ResponseEntity<WriterDto> getById(@PathVariable("writerId") final String writerId){
        final Writer writer = writerService.getById(writerId);
        return ResponseEntity.ok(writerMapper.toWriterDto(writer));
    }
    @PostMapping("/{writerId}")
    public ResponseEntity<Address> addAddressToWrtier(@PathVariable("writerId") final String writerId,
                                                      @RequestBody final AddressCommand addressCommand){
        final Address address = writerService.addContactToWriter(writerId, addressCommand);

        return ResponseEntity.ok(address);
    }
}
