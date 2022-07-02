package com.example.xportfolio.model;



import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Skills extends AbstractEntity{

    private String name;
    private String prct_master;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Writer writer;

    public void setWriter(Writer writer) {
        this.writer = writer;
    }
}
