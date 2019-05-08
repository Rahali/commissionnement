package com.malt.price.commissionnement.pojo;

import java.io.*;
import javax.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
public class MissionDuration implements Serializable {
    @Id
    @GeneratedValue()
    private Long id;

    private String durationType;

    private String gt;

}
