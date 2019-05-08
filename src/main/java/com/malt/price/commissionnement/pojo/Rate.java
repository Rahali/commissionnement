package com.malt.price.commissionnement.pojo;

import java.io.*;
import javax.persistence.*;
import javax.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.*;


@Setter
@Getter
@Entity
public class Rate implements Serializable {

    @Id
    @GeneratedValue()
    private Long id;
    private String percent;

}
