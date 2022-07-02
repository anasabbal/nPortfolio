package com.example.xportfolio.command;


import com.example.xportfolio.core.Validate;
import com.example.xportfolio.util.AssertValidation;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class WriterCommand implements Validate {
    private String firstName;
    private String lastName;
    private String pd_profile;

    public Set<FormationCommand> formationCommands;


    @Override
    public void validate(){
        AssertValidation.isEmpty(firstName);
        AssertValidation.isEmpty(lastName);
        AssertValidation.isEmpty(pd_profile);
    }
}
