package com.malt.price.commissionnement.pojo;

import java.util.*;
import javax.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
public class Rule {
    @Id
    @GeneratedValue()
    private Long id;

    private String name;

    private Rate rate;

    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval=true)
    private Restrictions restrictionsList;


}
