package com.example.xportfolio.controller;


import com.example.xportfolio.command.FormationCommand;
import com.example.xportfolio.dto.FormationDto;
import com.example.xportfolio.mapper.FormationMapper;
import com.example.xportfolio.model.Formation;
import com.example.xportfolio.service.formation.FormationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.xportfolio.cons.ResourcePath.*;


@RestController
@RequestMapping(V1+FORMATION)
@RequiredArgsConstructor
public class FormationController {

    private final FormationService formationService;
    private final FormationMapper formationMapper;


    @GetMapping
    public ResponseEntity<Page<FormationDto>> getAllFormation(Pageable pageable){
        return ResponseEntity.ok(formationService.getAllFormation(pageable));
    }
    @GetMapping("/{formationId}")
    public ResponseEntity<FormationDto> getById(@PathVariable("formationId") String  formationId){
        final Formation formation = formationService.getOne(formationId);

        return ResponseEntity.ok(formationMapper.toFormationDto(formation));
    }

    @PostMapping("/{writerId}")
    public ResponseEntity<String> addFormationToWriter(@PathVariable("writerId") final String writerId,
                                                       @RequestBody final FormationCommand formationCommand){
        formationService.addFormationToWriter(writerId, formationCommand);

        return ResponseEntity.ok("Formation added");
    }
    @PutMapping("/{formationId}")
    public ResponseEntity<FormationDto> updateFormation(@PathVariable("formationId") final String formationId,
                                                        @RequestBody final FormationCommand formationCommand){
        final Formation formation = formationService.updateFormation(formationId, formationCommand);

        return ResponseEntity.ok(formationMapper.toFormationDto(formation));
    }
    @DeleteMapping("/{formationId}")
    public ResponseEntity<String> deleteFormation(@PathVariable("formationId") final String formationId){
        formationService.deleteFormation(formationId);
        return ResponseEntity.ok("Formation deleted successfully");
    }
}
