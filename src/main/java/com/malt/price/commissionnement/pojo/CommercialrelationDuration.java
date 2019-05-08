package com.malt.price.commissionnement.pojo;

import java.io.*;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class CommercialrelationDuration implements Serializable {
    @Id
    @GeneratedValue()
    private Long id;

    private String gt;

}
