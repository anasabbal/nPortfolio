package com.example.xportfolio.model;




import com.example.xportfolio.command.FormationCommand;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Formation extends AbstractEntity{

    private String title;
    private String description;
    private Date begin_at;
    private Date end_at;

    @ManyToOne(optional = false)
    private Writer writer;


    public static Formation createFormation(final FormationCommand formationCommand){
        final Formation formation = new Formation();

        formation.begin_at = formationCommand.getBegin_at();
        formation.description = formationCommand.getDescription();
        formation.title = formationCommand.getTitle();
        formation.end_at = formationCommand.getEnd_at();

        return formation;
    }

    public void update(final FormationCommand formationCommand){
        this.title = formationCommand.getTitle();
        this.description = formationCommand.getDescription();
        this.begin_at = formationCommand.getBegin_at();
        this.end_at = formationCommand.getEnd_at();
    }
    public void linkToWriter(Writer writer){
        this.writer = writer;
    }
}
