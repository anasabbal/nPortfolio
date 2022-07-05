package com.example.xportfolio.service.skills;


import com.example.xportfolio.command.SkillsCommand;
import com.example.xportfolio.dto.SkillsDto;
import com.example.xportfolio.exception.BusinessException;
import com.example.xportfolio.exception.ExceptionPayloadFactory;
import com.example.xportfolio.mapper.SkillsMapper;
import com.example.xportfolio.model.Skills;
import com.example.xportfolio.model.Writer;
import com.example.xportfolio.repository.SkillsRepository;
import com.example.xportfolio.repository.WriterRepository;
import com.example.xportfolio.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SkillsServiceImpl implements SkillsService{


    private final SkillsRepository skillsRepository;
    private final WriterRepository writerRepository;
    private final SkillsMapper skillsMapper;


    @Override
    public Page<SkillsDto> getAllSkills(Pageable pageable) {
        Page<Skills> skills = skillsRepository.findAll(pageable);

        return skills.map(skillsMapper::toSkillsDto);
    }

    @Override
    public Skills getOne(String skillsId) {
        log.info("Begin fetching skills with id {}", skillsId);

        final Skills skills = skillsRepository.findById(skillsId).
                orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.SKILLS_NOT_FOUND.get()));
        log.info("Fetching skills with payload {} Done!", JSONUtil.toJSON(skills));

        return skills;
    }

    @Override
    public Skills addSkillsToWriter(String writerId, SkillsCommand skillsCommand) {
        log.info("Begin fetching writer with id {}", writerId);
        final Writer writer = writerRepository.findById(writerId)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.WRITER_NOT_FOUND.get()));
        log.info("Fetching writer with payload {} Done !", JSONUtil.toJSON(writer));

        final Skills skills = skillsRepository.save(writer.addSkills(skillsCommand));

        return skills;
    }

    @Override
    public Skills updateSkills(String skillsId, SkillsCommand skillsCommand) {
        final Skills skills = getOne(skillsId);
        log.info("Begin updating skills with id {}", skills);
        skills.update(skillsCommand);
        log.info("Updating skills with id {} successfully", skillsId);

        return skillsRepository.save(skills);
    }
    @Override
    public void deleteSkills(String skillsId) {
        final Skills skills = getOne(skillsId);
        log.info("Begin deleting skills with id {}", skills);
        skillsRepository.delete(skills);
        log.info("Deleting skills with id {} successfully", skills);
    }
}
