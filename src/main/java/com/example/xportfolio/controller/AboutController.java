package com.example.xportfolio.controller;


import com.example.xportfolio.command.AboutCommand;
import com.example.xportfolio.dto.AboutDto;
import com.example.xportfolio.mapper.AboutMapper;
import com.example.xportfolio.model.About;
import com.example.xportfolio.service.about.AboutService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.example.xportfolio.cons.ResourcePath.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(V1 + ABOUT)
public class AboutController {

    private final AboutService aboutService;
    private final AboutMapper aboutMapper;


    @PostMapping("{writerId}")
    public ResponseEntity<AboutDto> createAbout(@PathVariable("writerId") final String writerId,
                                                @RequestBody final AboutCommand aboutCommand){
        final About about = aboutService.createAbout(writerId, aboutCommand);
        return ResponseEntity.ok(aboutMapper.toAboutDto(about));
    }
    @GetMapping("{aboutId}")
    public ResponseEntity<AboutDto> getById(@PathVariable("aboutId") final String aboutId){
        final About about = aboutService.findById(aboutId);

        return ResponseEntity.ok(aboutMapper.toAboutDto(about));
    }
    @PutMapping("{aboutId}")
    public ResponseEntity<AboutDto> updateAbout(@PathVariable("aboutId") final String aboutId,
                                                @RequestBody final AboutCommand aboutCommand){
        final About about = aboutService.updateAbout(aboutId, aboutCommand);

        return ResponseEntity.ok(aboutMapper.toAboutDto(about));
    }
}
