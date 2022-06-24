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
    private Contact contact;
    private About about;
    private Set<Formation> formations;
    private Set<Experience> experiences;
    private Lang lang;
    private Set<Skills> skills;
}
