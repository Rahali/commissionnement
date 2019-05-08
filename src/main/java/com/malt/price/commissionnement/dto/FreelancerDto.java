package com.malt.price.commissionnement.dto;

import com.fasterxml.jackson.annotation.*;
import java.io.*;
import lombok.*;

@Setter
@Getter
public class FreelancerDto implements Serializable {
    @JsonProperty("ip")
    private String ip;
    private String location;
}
