package com.example.xportfolio.service.writer;



import com.example.xportfolio.command.WriterCommand;
import com.example.xportfolio.exception.BusinessException;
import com.example.xportfolio.exception.ExceptionPayloadFactory;
import com.example.xportfolio.model.Writer;
import com.example.xportfolio.repository.WriterRepository;
import com.example.xportfolio.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

@Service
@RequiredArgsConstructor
@Slf4j
public class WriterServiceImpl implements WriterService{

    private final WriterRepository writerRepository;

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
        final Writer writer = writerRepository.findById(writerId)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.WRITER_NOT_FOUND.get()));

        return writer;
    }
    @Override
    public Writer uploadImage(String writerId, MultipartFile file){
        final Writer writer = getById(writerId);
        try {
            writer.setPd_profile(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return writerRepository.save(writer);
    }
    @Override
    public byte[] getImage(String writerId){
        log.info("Start retrieving image from writer with  id '{}'", writerId);

        final Writer writer = getById(writerId);

        byte[] file = writer.getPd_profile();

        return file;
    }

    /*@PostConstruct
    public void initPhotoProfile()throws IOException{
        log.info("loading Writer picture...");
        InputStream inputStream = WriterServiceImpl.class.getClassLoader().getResourceAsStream("images/anas.png");
        File logo = new File("src/main/resources/images/anas.png");
    }*/
}
