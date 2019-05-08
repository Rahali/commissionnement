package com.malt.price.commissionnement.dto;

import com.fasterxml.jackson.annotation.*;
import java.io.*;
import lombok.*;


@Setter
@Getter
public class OrDto implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("@mission.duration")
    private DurationDto missionDuration;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("@commercialrelation.duration")
    private DurationDto commercialrelationDurationDto;


}
