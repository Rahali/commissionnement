package com.malt.price.commissionnement.dto;


import com.fasterxml.jackson.annotation.*;
import java.io.*;
import lombok.*;

@Setter
@Getter
public class CountryDto implements Serializable {

    @JsonProperty("ip")
    private String ip;

    @JsonProperty("type")
    private String type;

    @JsonProperty("continent_code")
    private String continentCode;

    @JsonProperty("continent_name")
    private String continentName;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("country_name")
    private String countryName;

    @JsonProperty("region_code")
    private String regionCode;

    @JsonProperty("region_name")
    private String regionName;

    @JsonProperty("city")
    private String city;

    @JsonProperty("zip")
    private String zip;

    @JsonProperty("latitude")
    private Double latitude;

    @JsonProperty("longitude")
    private Double longitude;


}
