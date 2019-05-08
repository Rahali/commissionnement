
package com.malt.price.commissionnement.dto;

import com.fasterxml.jackson.annotation.*;
import java.io.*;
import lombok.*;

@Getter
@Setter
public class CommandDto implements Serializable {

    @JsonProperty("client")
    private ClientDto clientDto;

    @JsonProperty("freelancer")
    private FreelancerDto freelancerDto;

    @JsonProperty("mission")
    private MissionDto missionDto;

    @JsonProperty("commercialrelation")
    private CommercialrelationDto commercialrelationDto;

}
