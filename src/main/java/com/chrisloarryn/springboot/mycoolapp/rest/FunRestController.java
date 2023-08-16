package com.chrisloarryn.springboot.mycoolapp.rest;

import com.chrisloarryn.springboot.mycoolapp.rest.domain.Dinosaur;
import com.chrisloarryn.springboot.mycoolapp.rest.domain.RandomResponse;
import com.chrisloarryn.springboot.mycoolapp.rest.service.ApiClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class FunRestController {

    private final ApiClientService apiClientService;

    public FunRestController(ApiClientService apiClientService) {
        this.apiClientService = apiClientService;
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello World! Time on the server is " + java.time.LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day!";
    }

    @GetMapping("/dinosaur")
    // return json
    public RandomResponse getDinosaur() {
        Dinosaur[] dinosaurs = apiClientService.fetchDataFromExternalAPI();

        RandomResponse randomResponse = new RandomResponse();
        randomResponse.setData(dinosaurs);
        randomResponse.setResults(dinosaurs.length);
        // return a random word from the array
        return randomResponse;
    }

    @GetMapping("/json")
    public String getJson() {
        return "{ \"name\": \"John\", \"age\": 31, \"city\": \"New York\" }";
    }
}
