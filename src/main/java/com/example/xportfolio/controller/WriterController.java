package com.example.xportfolio.controller;



import com.example.xportfolio.command.WriterCommand;
import com.example.xportfolio.dto.WriterDto;
import com.example.xportfolio.mapper.WriterMapper;
import com.example.xportfolio.model.Writer;
import com.example.xportfolio.service.writer.WriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import static com.example.xportfolio.cons.ResourcePath.*;

@RestController
@RequestMapping( V1+ WRITER)
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
    @PostMapping(value = "/{writerId}/file", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<WriterDto> uploadImage(@PathVariable("writerId") final String writerId, @RequestParam("file") MultipartFile file){
        final Writer writer = writerService.uploadImage(writerId, file);

        return ResponseEntity.ok(writerMapper.toWriterDto(writer));
    }
    /*@GetMapping("/image/{writerId}")
    public ResponseEntity<byte[]> getById(@PathVariable("writerId") final String writerId){
        final byte[] bytes = writerService.getImage(writerId);
        return ResponseEntity.ok(bytes);
    }*/
}
