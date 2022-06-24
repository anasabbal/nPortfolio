package com.example.xportfolio.command;


import com.example.xportfolio.util.AssertValidation;
import lombok.Getter;

@Getter
public class WriterCommand {
    private String firstName;
    private String lastName;
    private String pd_profile;


    public void validate(){
        AssertValidation.isEmpty(firstName);
        AssertValidation.isEmpty(lastName);
        AssertValidation.isEmpty(pd_profile);
    }
}
