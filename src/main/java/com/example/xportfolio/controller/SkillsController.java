package com.example.xportfolio.controller;


import com.example.xportfolio.command.SkillsCommand;
import com.example.xportfolio.dto.LangDto;
import com.example.xportfolio.dto.SkillsDto;
import com.example.xportfolio.mapper.SkillsMapper;
import com.example.xportfolio.model.Skills;
import com.example.xportfolio.service.skills.SkillsService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.xportfolio.cons.ResourcePath.*;

@RestController
@RequestMapping(V1+ SKILLS)
@RequiredArgsConstructor
public class SkillsController {

    private final SkillsService skillsService;
    private final SkillsMapper skillsMapper;

    @GetMapping
    public ResponseEntity<Page<SkillsDto>> getAllSkills(Pageable pageable){
        return ResponseEntity.ok(skillsService.getAllSkills(pageable));
    }
    @PostMapping("{writerId}")
    public ResponseEntity<String> addSkillsToWriter(@PathVariable("writerId") final String writerId,
                                                       @RequestBody final SkillsCommand skillsCommand){
        skillsService.addSkillsToWriter(writerId, skillsCommand);

        return ResponseEntity.ok("skills added");
    }
    @GetMapping("/{skillsId}")
    public ResponseEntity<SkillsDto> getSkillsById(@PathVariable("skillsId") final String skillsId){
        final Skills skills = skillsService.getOne(skillsId);
        return ResponseEntity.ok(skillsMapper.toSkillsDto(skills));
    }
    @PutMapping("/{skillsId}")
    public ResponseEntity<SkillsDto> updateSkills(@PathVariable("skillsId") String skillsId,
                                                  @RequestBody final SkillsCommand skillsCommand){
        final Skills skills = skillsService.updateSkills(skillsId, skillsCommand);
        return ResponseEntity.ok(skillsMapper.toSkillsDto(skills));
    }
    @DeleteMapping("/{skillsId}")
    public ResponseEntity<String> deleteLang(@PathVariable("skillsId")final String skillsId){
        skillsService.deleteSkills(skillsId);
        return ResponseEntity.ok("Skills deleted successfully");
    }
}
