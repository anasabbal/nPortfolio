package com.example.xportfolio.service.formation;


import com.example.xportfolio.command.FormationCommand;
import com.example.xportfolio.model.Formation;
import com.example.xportfolio.model.Writer;
import com.example.xportfolio.repository.FormationRepository;
import com.example.xportfolio.repository.WriterRepository;
import com.example.xportfolio.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FormationServiceImpl implements FormationService{

    private final FormationRepository formationRepository;
    private final WriterRepository writerRepository;


    @Override
    public Formation getOne(String formationId) {
        log.info("Begin fetching formation with id {}", formationId);

        final Formation formation = formationRepository.findById(formationId).get();

        return formation;
    }

    @Override
    public Formation addFormationToWriter(String writerId, FormationCommand formationCommand){
        final Writer writer = writerRepository.findById(writerId).get();

        log.info("Begin creating and adding formation with payload {} to writer with id {}", JSONUtil.toJSON(formationCommand), writerId);

        final Formation formation = formationRepository.save(writer.addFormation(formationCommand));

        return formation;
    }
}
