package com.example.xportfolio.dto;

import com.example.xportfolio.model.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;



@Getter
@Setter
public class WriterDto {
    private String id;
    private String firstName;
    private String lastName;
    private String pd_profile;
    private ContactDto contact;
    private AboutDto about;
    private Set<FormationDto> formations;
    private Set<ExperienceDto> experiences;
    private LangDto lang;
    private Set<SkillsDto> skills;
}