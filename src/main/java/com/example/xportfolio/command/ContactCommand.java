package com.example.xportfolio.command;


import com.example.xportfolio.core.Validate;
import com.example.xportfolio.util.AssertValidation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactCommand implements Validate {
    private String email;
    private String phone;
    private String gmail_url;
    private String github_link;


    @Override
    public void validate() {
        AssertValidation.isEmail(email);
        AssertValidation.isMobile(phone);
        AssertValidation.isGithubUrl(github_link);
    }
}
