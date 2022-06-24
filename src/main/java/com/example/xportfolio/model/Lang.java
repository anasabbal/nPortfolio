package com.example.xportfolio.model;



import com.example.xportfolio.enums.RankTypeLang;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
public class Lang extends AbstractEntity {
    private String name;

    @Enumerated(EnumType.STRING)
    private RankTypeLang rankTypeLang;
}