package com.example.xportfolio.command;

import com.example.xportfolio.enums.RankTypeLang;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LangCommand {

    private String name;
    private RankTypeLang rankTypeLang;
}
