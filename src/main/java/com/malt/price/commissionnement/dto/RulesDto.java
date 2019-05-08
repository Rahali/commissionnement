package com.malt.price.commissionnement.dto;

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.*;
import java.io.*;
import lombok.*;


@Setter
@Getter
@ApiModel(description = "les informations concerant les Regles. ")
public class RulesDto implements Serializable {

    @ApiModelProperty(notes = "ID")
    private Long id;
    @ApiModelProperty(notes = "name")

    @JsonProperty("name")
    private String name;
    @ApiModelProperty(notes = "rate")

    @JsonProperty("rate")
    private RateDto rateDto;
    @ApiModelProperty(notes = "restrictions")

    @JsonProperty("restrictions")
    private RestrictionsDto restrictionsDto;

}
