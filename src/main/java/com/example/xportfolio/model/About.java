package com.example.xportfolio.model;



import com.example.xportfolio.command.AboutCommand;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class About extends AbstractEntity{

    private String description;

    @OneToOne(optional = false, mappedBy = "about")
    private Writer writer;

    public static About createAbout(final AboutCommand aboutCommand){
        final About about = new About();

        about.description = aboutCommand.getDescription();
        return about;
    }
    public void linkToWriter(Writer writer){
        this.writer = writer;
    }

    public void update(final AboutCommand aboutCommand){
        this.description = aboutCommand.getDescription();
    }
}
