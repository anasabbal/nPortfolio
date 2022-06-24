package com.example.xportfolio.controller;


import com.example.xportfolio.service.PdfService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/resume")
@RequiredArgsConstructor
public class PdfController {

    private final PdfService pdfService;

    @PostMapping("/{writerId}")
    public ResponseEntity<String> postResume(@PathVariable("writerId") String writerId) throws FileNotFoundException {
        return ResponseEntity.ok(pdfService.createDocument(writerId));
    }
}
