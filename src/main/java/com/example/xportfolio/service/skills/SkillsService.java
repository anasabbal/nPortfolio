package com.example.xportfolio.service.skills;

import com.example.xportfolio.command.FormationCommand;
import com.example.xportfolio.command.SkillsCommand;
import com.example.xportfolio.dto.SkillsDto;
import com.example.xportfolio.model.Formation;
import com.example.xportfolio.model.Skills;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SkillsService {
    Page<SkillsDto> getAllSkills(Pageable pageable);
    Skills getOne(String skillsId);
    Skills addSkillsToWriter(String skillsId, SkillsCommand skillsCommand);
    Skills updateSkills(String skillsId, final SkillsCommand skillsCommand);
    void deleteSkills(String skillsId);
}
