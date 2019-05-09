package com.malt.price.commissionnement.service;

import com.malt.price.commissionnement.dto.*;
import org.apache.http.client.*;
import org.apache.http.impl.client.*;
import org.springframework.http.*;
import org.springframework.http.client.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

@Service
public class IpStackService {


    public String getCodeCountry(String ip) {

        String codeCountry = null;
        String ipStackUrl = "http://api.ipstack.com/" + ip + "?access_key=6acd814efa092cb6832d18d8941ce83d";
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate = createRestTemplate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ResponseEntity<CountryDto> response = restTemplate.getForEntity(ipStackUrl, CountryDto.class);
        if (null != response && null != response.getBody()) {

            codeCountry = response.getBody().getCountryCode();
        }
        return codeCountry;
    }

    private RestTemplate createRestTemplate() {
        HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        HttpClient httpClient = clientBuilder.build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setHttpClient(httpClient);

        return new RestTemplate(factory);
    }
}

