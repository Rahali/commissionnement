package com.malt.price.commissionnement.dto;

import com.fasterxml.jackson.annotation.*;
import java.io.*;
import java.util.*;
import lombok.*;


@Setter
@Getter
public class RulesDto implements Serializable {


    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("rate")
    private RateDto rateDto;

    @JsonProperty("restrictions")
    private List<RestrictionsDto> restrictionsDto;

}
