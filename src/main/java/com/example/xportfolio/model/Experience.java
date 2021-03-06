package com.example.xportfolio.model;




import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Experience extends AbstractEntity{

    private String title;
    private String description;
    private Date begin_at;
    private Date end_at;

    @ManyToOne(optional = false)
    private Writer writer;
}
