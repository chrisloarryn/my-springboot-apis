package com.chrisloarryn.springboot.mycoolapp.rest.service;

import com.chrisloarryn.springboot.mycoolapp.rest.domain.ApiResponse;
import com.chrisloarryn.springboot.mycoolapp.rest.domain.Dinosaur;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiClientService {

    private final String API_URL = "https://simple-script-dinosaur-scrapping-production.up.railway.app/getAllDinoList";

    private final RestTemplate restTemplate;

    public ApiClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Dinosaur[] fetchDataFromExternalAPI() {

        ApiResponse response = restTemplate.getForObject(API_URL, ApiResponse.class);

        if (response == null) {
            // return an empty array
            return new Dinosaur[0];
        }

        return response.getData();
    }
}