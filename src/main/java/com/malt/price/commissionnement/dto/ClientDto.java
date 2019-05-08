package com.malt.price.commissionnement.dto;

import com.fasterxml.jackson.annotation.*;
import java.io.*;
import lombok.*;

@Getter
@Setter
public class ClientDto implements Serializable {
    @JsonProperty("ip")
    private String ip;
}
