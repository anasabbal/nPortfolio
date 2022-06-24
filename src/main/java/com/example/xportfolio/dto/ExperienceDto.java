package com.example.xportfolio.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class ExperienceDto {
    private String title;
    private String description;
    private Date begin_at;
    private Date end_at;
}
