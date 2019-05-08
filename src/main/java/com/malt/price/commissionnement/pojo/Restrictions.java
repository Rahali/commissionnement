package com.malt.price.commissionnement.pojo;

import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.*;

@Setter
@Getter
@Entity
public class Restrictions implements Serializable {

    @Id
    @GeneratedValue()
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MissionDuration> duration;

    private String clientLocation;

    private String freelancerLocation;


}
