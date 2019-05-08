package com.malt.price.commissionnement.dto;

import com.fasterxml.jackson.annotation.*;
import java.io.*;
import lombok.*;


@Setter
@Getter
public class OrDto implements Serializable {


    @JsonProperty("@mission.duration")
    private DurationDto missionDuration;

    @JsonProperty("@commercialrelation.duration")
    private DurationDto commercialrelationDurationDto;


}
