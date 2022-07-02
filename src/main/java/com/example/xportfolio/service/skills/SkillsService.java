package com.example.xportfolio.service.skills;

import com.example.xportfolio.command.FormationCommand;
import com.example.xportfolio.command.SkillsCommand;
import com.example.xportfolio.model.Formation;
import com.example.xportfolio.model.Skills;

public interface SkillsService {

    Skills getOne(String skillsId);
    Skills addSkillsToWriter(String skillsId, SkillsCommand skillsCommand);
}
