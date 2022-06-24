package com.example.xportfolio.service.about;


import com.example.xportfolio.command.AboutCommand;
import com.example.xportfolio.model.About;
import com.example.xportfolio.repository.AboutRepository;
import com.example.xportfolio.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService{


    private final AboutRepository aboutRepository;

    @Override
    public About createAbout(AboutCommand aboutCommand) {
        log.info("Begin creating About with payload {}", JSONUtil.toJSON(aboutCommand));

        final About about = aboutRepository.save(About.createAbout(aboutCommand));

        return about;
    }
}
