package com.example.xportfolio.service.about;


import com.example.xportfolio.command.AboutCommand;
import com.example.xportfolio.model.About;
import com.example.xportfolio.model.Writer;
import com.example.xportfolio.repository.AboutRepository;
import com.example.xportfolio.repository.WriterRepository;
import com.example.xportfolio.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService{
    private final AboutRepository aboutRepository;
    private final WriterRepository writerRepository;

    @Override
    public About createAbout(String writerId, AboutCommand aboutCommand) {
        log.info("Begin creating About with payload {}", JSONUtil.toJSON(aboutCommand));

        final Writer writer = writerRepository.findById(writerId).orElseThrow();
        final About about = aboutRepository.save(writer.addAboutToWriter(aboutCommand));

        return about;
    }

    @Override
    public About updateAbout(String aboutId, AboutCommand aboutCommand) {
        final About about = findById(aboutId);
        about.update(aboutCommand);

        return aboutRepository.save(about);
    }

    @Override
    public About findById(String aboutId) {
        log.info("Begin fetching about with id {}", aboutId);
        final About about = aboutRepository.findById(aboutId).orElseThrow();

        return about;
    }
}
