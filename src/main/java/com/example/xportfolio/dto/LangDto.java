package com.example.xportfolio.dto;

import com.example.xportfolio.enums.RankTypeLang;
import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
public class LangDto {
    private String id;
    private String name;
    private RankTypeLang rankTypeLang;
}
