package com.example.xportfolio.service.formation;


import com.example.xportfolio.command.FormationCommand;
import com.example.xportfolio.dto.FormationDto;
import com.example.xportfolio.exception.BusinessException;
import com.example.xportfolio.exception.ExceptionPayloadFactory;
import com.example.xportfolio.mapper.FormationMapper;
import com.example.xportfolio.model.Formation;
import com.example.xportfolio.model.Writer;
import com.example.xportfolio.repository.FormationRepository;
import com.example.xportfolio.repository.WriterRepository;
import com.example.xportfolio.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FormationServiceImpl implements FormationService{

    private final FormationRepository formationRepository;
    private final WriterRepository writerRepository;
    private final FormationMapper formationMapper;


    @Override
    public Page<FormationDto> getAllFormation(Pageable pageable) {
        Page<Formation> formations = formationRepository.findAll(pageable);
        return formations.map(formationMapper::toFormationDto);
    }

    @Override
    public Formation getOne(String formationId) {
        log.info("Begin fetching formation with id {}", formationId);

        final Formation formation = formationRepository.findById(formationId).
                orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.FORMATION_NOT_FOUND.get()));

        return formation;
    }

    @Override
    public Formation addFormationToWriter(String writerId, FormationCommand formationCommand){
        final Writer writer = writerRepository.findById(writerId)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.WRITER_NOT_FOUND.get()));

        log.info("Begin creating and adding formation with payload {} to writer with id {}", JSONUtil.toJSON(formationCommand), writerId);

        final Formation formation = formationRepository.save(writer.addFormation(formationCommand));

        return formation;
    }

    @Override
    public Formation updateFormation(String formationId, FormationCommand formationCommand) {
        final Formation formation = getOne(formationId);
        log.info("Begin updating formation wih payload {}", JSONUtil.toJSON(formation));

        formation.update(formationCommand);
        log.info("Finish updating formation with id {}", formation);

        return formationRepository.save(formation);
    }

    @Override
    public void deleteFormation(String formationId) {
        final Formation formation = getOne(formationId);
        log.info("Begin deleting formation with id {}", formation);
        formationRepository.delete(formation);
    }
}
