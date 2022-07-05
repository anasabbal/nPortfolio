package com.example.xportfolio.service.lang;


import com.example.xportfolio.command.LangCommand;
import com.example.xportfolio.exception.BusinessException;
import com.example.xportfolio.exception.ExceptionPayloadFactory;
import com.example.xportfolio.model.Lang;
import com.example.xportfolio.model.Writer;
import com.example.xportfolio.repository.LangRepository;
import com.example.xportfolio.repository.WriterRepository;
import com.example.xportfolio.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LangServiceImpl implements LangService{

    private final LangRepository langRepository;
    private final WriterRepository writerRepository;


    @Override
    public Lang createOne(String writerId, LangCommand langCommand){
        log.info("Begin fetching writer with id {}", writerId);
        final Writer writer = writerRepository.findById(writerId)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.WRITER_NOT_FOUND.get()));

        final Lang lang = langRepository.save(writer.addLang(langCommand));

        return lang;
    }

    @Override
    public Lang getById(String langId) {
        log.info("Begin fetching lang with id {}", langId);
        final Lang lang = langRepository.findById(langId).
                orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.LANGUAGE_NOT_FOUND.get()));

        log.info("Fetching Lang with payload {}", JSONUtil.toJSON(lang));
        return lang;
    }

    @Override
    public Lang updateLang(String langId, LangCommand langCommand) {
        final Lang lang = getById(langId);

        lang.updateLang(langCommand);

        return langRepository.save(lang);
    }
}
