package com.example.xportfolio.service;

import com.example.xportfolio.model.Writer;

import java.io.FileNotFoundException;

public interface PdfService {

    String createDocument(String writerId) throws FileNotFoundException;
    byte[] getDocument(String file_name);
}
