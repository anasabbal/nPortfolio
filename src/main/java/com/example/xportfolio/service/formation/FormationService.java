package com.example.xportfolio.service.formation;

import com.example.xportfolio.command.FormationCommand;
import com.example.xportfolio.dto.FormationDto;
import com.example.xportfolio.model.Formation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FormationService {

    Page<FormationDto> getAllFormation(Pageable pageable);
    Formation getOne(String formationId);
    Formation addFormationToWriter(String writerId, FormationCommand formationCommand);
    Formation updateFormation(String formationId, final FormationCommand formationCommand);
    void deleteFormation(String formationId);
}
