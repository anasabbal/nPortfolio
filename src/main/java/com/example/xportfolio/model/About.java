package com.example.xportfolio.model;



import com.example.xportfolio.command.AboutCommand;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class About extends AbstractEntity{

    private String description;

    public static About createAbout(final AboutCommand aboutCommand){
        final About about = new About();

        about.description = aboutCommand.getDescription();
        return about;
    }
}
