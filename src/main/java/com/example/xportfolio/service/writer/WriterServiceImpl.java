package com.example.xportfolio.service.writer;



import com.example.xportfolio.command.WriterCommand;
import com.example.xportfolio.model.Writer;
import com.example.xportfolio.repository.WriterRepository;
import com.example.xportfolio.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
        final Writer writer = writerRepository.findById(writerId).orElseThrow();

        return writer;
    }
}
