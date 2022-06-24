package com.example.xportfolio.service;


import com.example.xportfolio.model.About;
import com.example.xportfolio.model.Writer;
import com.example.xportfolio.repository.AboutRepository;
import com.example.xportfolio.repository.WriterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class PdfServiceImpl implements PdfService{

    private final WriterRepository writerRepository;

    @Override
    public String createDocument(String writerId) throws FileNotFoundException {
        return null;
    }

    @Override
    public byte[] getDocument(String file_name) {
        return new byte[0];
    }

    /* Fonts for lines
    private static final Font nameStyle = new Font(Font.FontFamily.HELVETICA, 12f, Font.BOLD);
    private static final Font emptyLineStyle = new Font(Font.FontFamily.HELVETICA, 4f, Font.BOLD);
    private static final Font headingStyle = new Font(Font.FontFamily.HELVETICA, 11f, Font.BOLD);
    private static final Font contactStyle = new Font(Font.FontFamily.HELVETICA, 11f, Font.ITALIC);
    private static final Font contentStyle = new Font(Font.FontFamily.HELVETICA, 10f);

    @Override
    public String createDocument(String writerId) {
        Writer writer = writerRepository.findById(writerId).get();
        Document document = new Document();
        try {
            String file_location = "src/main/file/" + writer.getFirstName() + ".pdf";
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(new File(file_location)));
            log.info("==========Pdf document is opened============");
            document.open();

            if(writer != null){
                if(writer.getAbout() != null){
                    addMetaData(document, writer.getAbout().getDescription());
                    log.info("Adding meta data");
                }
                addLayoutConfig(document);
            }
            document.close();
            pdfWriter.close();
        }catch (Exception e){
            // TODO: handle exception
            log.error("==========Error while creating pdf============");
            log.error(e.getMessage());
        }
        return "Failed";
    }

    @Override
    public byte[] getDocument(String file_name) {
        return new byte[0];
    }
    public static void addMetaData(Document document, String writer){
        document.addTitle("My Resume PDF");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor(writer);
        document.addCreator("BuildByResume.com");
    }
    public static void addLayoutConfig(Document document) {
        document.setPageSize(PageSize.A4);
        document.setMargins(50f, 44f, 69f, 69f);
    }
    public static void addEmptyLines(Document document) throws DocumentException {
        Paragraph emptyLine = new Paragraph("", emptyLineStyle);
        document.add(emptyLine);
    }
    public static void addAbout(Document document, About about){
        try {
            Paragraph aboutDescription = new Paragraph(about.getDescription() + "\n", nameStyle);
            aboutDescription.setAlignment(Element.ALIGN_CENTER);
            document.add(aboutDescription);
        }catch (DocumentException e){
            e.printStackTrace();
        }
    }*/
}
