package com.example.xportfolio.model;



import com.example.xportfolio.command.LangCommand;
import com.example.xportfolio.enums.RankTypeLang;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Lang extends AbstractEntity {
    private String name;

    @Enumerated(EnumType.STRING)
    private RankTypeLang rankTypeLang;

    @ManyToOne
    private Writer writer;


    public static Lang createLang(final LangCommand langCommand){
        final Lang lang = new Lang();

        lang.name = langCommand.getName();
        lang.rankTypeLang = langCommand.getRankTypeLang();

        return lang;
    }
    public void updateLang(final LangCommand langCommand){
        this.name = langCommand.getName();
        this.rankTypeLang = langCommand.getRankTypeLang();
    }
    public void linkToWriter(Writer writer){
        this.writer = writer;
    }
}
