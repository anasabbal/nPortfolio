package com.example.xportfolio.controller;


import com.example.xportfolio.command.AboutCommand;
import com.example.xportfolio.dto.AboutDto;
import com.example.xportfolio.mapper.AboutMapper;
import com.example.xportfolio.model.About;
import com.example.xportfolio.service.about.AboutService;
import lombok.RequiredArgsConstructor;
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
}
