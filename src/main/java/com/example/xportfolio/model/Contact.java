package com.example.xportfolio.model;



import lombok.Data;
import org.hibernate.type.StringNVarcharType;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
public class Contact extends AbstractEntity{

    @OneToOne
    private Address address;

    private String email;
    private String phone;
    private String gmail_url;
    private String github_link;


}
