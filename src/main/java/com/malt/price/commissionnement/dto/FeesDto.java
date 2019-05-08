package com.malt.price.commissionnement.dto;

import com.fasterxml.jackson.annotation.*;
import java.io.*;
import lombok.*;

@Setter
@Getter
public class FeesDto implements Serializable {


    @JsonProperty("fees")
    private String fees;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("reason")
    private String reason;

}