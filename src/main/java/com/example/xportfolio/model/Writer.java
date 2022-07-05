package com.example.xportfolio.model;


import com.example.xportfolio.command.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Writer extends AbstractEntity{


    private String firstName;
    private String lastName;

    @Lob
    private byte[] pd_profile;

    @OneToOne
    @JsonManagedReference
    private Contact contact;

    @OneToOne
    private About about;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "writer")
    @JsonIgnore
    private Set<Formation> formations;

    @OneToMany(mappedBy = "writer", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Experience> experiences;

    @OneToMany(mappedBy = "writer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Lang> lang;

    @OneToMany(mappedBy = "writer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Skills> skills;

    public Writer() {

    }

    public static Writer createOne(final WriterCommand writerCommand){
        final Writer writer = new Writer();

        writer.firstName = writerCommand.getFirstName();
        writer.lastName = writerCommand.getLastName();
        return writer;
    }

    public static Set<Formation> createFormation(final Set<FormationCommand> formationCommand){
        return formationCommand.stream().map(Formation::createFormation).collect(Collectors.toSet());
    }
    public Formation addFormation(final FormationCommand formationCommand){
        final Formation formation = Formation.createFormation(formationCommand);

        formation.linkToWriter(this);

        return formation;
    }
    public Lang addLang(final LangCommand langCommand){
        final Lang lang1 = Lang.createLang(langCommand);

        lang1.linkToWriter(this);

        return lang1;
    }
    public Skills addSkills(final SkillsCommand skillsCommand){
        final Skills skills1 = Skills.createSkills(skillsCommand);

        skills1.linkToWriter(this);

        return skills1;
    }
    public void linkToAbout(About about){
        this.about = about;
    }
}
