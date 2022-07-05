package com.example.xportfolio.controller;


import com.example.xportfolio.command.LangCommand;
import com.example.xportfolio.dto.FormationDto;
import com.example.xportfolio.dto.LangDto;
import com.example.xportfolio.mapper.LangMapper;
import com.example.xportfolio.model.Lang;
import com.example.xportfolio.service.lang.LangService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.xportfolio.cons.ResourcePath.*;

@RestController
@RequestMapping(V1 + LANG)
@RequiredArgsConstructor
public class LangController {

    private final LangService langService;
    private final LangMapper langMapper;

    @GetMapping
    public ResponseEntity<Page<LangDto>> getAllLang(Pageable pageable){
        return ResponseEntity.ok(langService.getAllLang(pageable));
    }
    @PostMapping("{writerId}")
    public ResponseEntity<LangDto> createOne(@PathVariable("writerId") final String writerId,
                                             @RequestBody final LangCommand langCommand){
        final Lang lang = langService.createOne(writerId, langCommand);

        return ResponseEntity.ok(langMapper.toLangDto(lang));
    }
    @GetMapping("{langId}")
    public ResponseEntity<LangDto> getById(@PathVariable("langId") final String langId){
        final Lang lang = langService.getById(langId);

        return ResponseEntity.ok(langMapper.toLangDto(lang));
    }
    @PutMapping("{langId}")
    public ResponseEntity<LangDto> updateLang(@PathVariable("langId") final String langId,
                                              @RequestBody LangCommand langCommand){
        final Lang lang = langService.updateLang(langId, langCommand);

        return ResponseEntity.ok(langMapper.toLangDto(lang));
    }
    @DeleteMapping("/{langId}")
    public ResponseEntity<String> deleteLang(@PathVariable("langId")final String langId){
        langService.deleteLang(langId);
        return ResponseEntity.ok("Language deleted successfully");
    }
}
