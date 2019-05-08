package com.malt.price.commissionnement.dto;

import com.fasterxml.jackson.annotation.*;
import java.io.*;
import java.util.*;
import lombok.*;

@Setter
@Getter
public class RestrictionsDto implements Serializable {


    @JsonProperty("@or")
    private List<OrDto> orDtoList;

    @JsonProperty("@client.location")
    private LocationDto clientLocationDto;

    @JsonProperty("@freelancer.location")
    private LocationDto freelancerLocationDto;


}
