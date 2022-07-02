package com.example.xportfolio.command;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class FormationCommand {
    private String title;
    private String description;
    private Date begin_at;
    private Date end_at;
}
