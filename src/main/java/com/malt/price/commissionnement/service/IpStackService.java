package com.malt.price.commissionnement.service;

import com.malt.price.commissionnement.dto.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

@Service
public class IpStackService {


    public String getCodeCountry(String ip) {

        String codeCountry = null;
        String ipStackUrl = "http://api.ipstack.com/"+ip+"?access_key=6acd814efa092cb6832d18d8941ce83d";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CountryDto> response = restTemplate.getForEntity(ipStackUrl, CountryDto.class);
        if (null != response && null != response.getBody()) {

            codeCountry = response.getBody().getCountryCode();
        }
        return codeCountry;
    }
}

