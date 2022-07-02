package com.example.xportfolio.controller;


import com.example.xportfolio.command.SkillsCommand;
import com.example.xportfolio.dto.SkillsDto;
import com.example.xportfolio.mapper.SkillsMapper;
import com.example.xportfolio.model.Skills;
import com.example.xportfolio.service.skills.SkillsService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.xportfolio.cons.ResourcePath.*;

@RestController
@RequestMapping(V1+ SKILLS)
@RequiredArgsConstructor
public class SkillsController {

    private final SkillsService skillsService;


    @PostMapping("{writerId}")
    public ResponseEntity<String> addSkillsToWriter(@PathVariable("writerId") final String writerId,
                                                       @RequestBody final SkillsCommand skillsCommand){
        skillsService.addSkillsToWriter(writerId, skillsCommand);

        return ResponseEntity.ok("skills added");
    }
}
