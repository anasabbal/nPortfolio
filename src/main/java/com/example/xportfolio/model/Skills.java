package com.example.xportfolio.model;



import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Skills extends AbstractEntity{

    private String name;
    private String prct_master;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Writer writer;

    public void setWriter(Writer writer) {
        this.writer = writer;
    }
}
