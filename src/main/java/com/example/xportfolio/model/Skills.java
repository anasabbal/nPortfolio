package com.example.xportfolio.model;



import com.example.xportfolio.command.SkillsCommand;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Skills extends AbstractEntity{

    private String name;
    private String prct_master;

    @ManyToOne(optional = false)
    private Writer writer;


    public static Skills createSkills(final SkillsCommand skillsCommand){
        final Skills skills = new Skills();
        skills.name = skillsCommand.getName();
        skills.prct_master = skillsCommand.getPrct_master();

        return skills;
    }
    public void update(final SkillsCommand skillsCommand){
        this.name = skillsCommand.getName();
        this.prct_master = skillsCommand.getPrct_master();
    }
    public void linkToWriter(Writer writer) {
        this.writer = writer;
    }
}
