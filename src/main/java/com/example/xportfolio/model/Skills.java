package com.example.xportfolio.model;



import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Skills extends AbstractEntity{

    private String name;
    private String prct_master;

    @ManyToOne(optional = false)
    private Writer writer;
}
