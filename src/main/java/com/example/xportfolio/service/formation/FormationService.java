package com.example.xportfolio.service.formation;

import com.example.xportfolio.command.FormationCommand;
import com.example.xportfolio.model.Formation;

public interface FormationService {

    Formation getOne(String formationId);
    public Formation addFormationToWriter(String writerId, FormationCommand formationCommand);
}
