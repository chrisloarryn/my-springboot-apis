package com.chrisloarryn.springboot.mycoolapp.rest.service;

import com.chrisloarryn.springboot.mycoolapp.rest.domain.Dinosaur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ApiClientServiceTest {

    @Mock
    private RestTemplate restTemplate;

    private ApiClientService apiClientService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        apiClientService = new ApiClientService(restTemplate);
    }

    @Test
    public void testFetchDataFromExternalAPI() {
        // Mock API response
        Dinosaur[] expectedResponse = {
                new Dinosaur("link1", "Dino1"),
                new Dinosaur("link2", "Dino2")
        };

        // Mock the restTemplate.getForObject() method
        when(restTemplate.getForObject(any(), eq(Dinosaur[].class)))
                .thenReturn(
                        Arrays.stream(expectedResponse).toList().toArray(new Dinosaur[0])
                );

        // Call the method under test
        Dinosaur[] actualResponse = apiClientService.fetchDataFromExternalAPI();

        // Verify the response
        assertEquals(expectedResponse.length, actualResponse.length);

        // Verify the restTemplate.getForObject() method was called
        verify(restTemplate, times(1))
                .getForObject(anyString(), eq(Dinosaur[].class));

        // Verify no other methods were called on the restTemplate
        verifyNoMoreInteractions(restTemplate);

        // Verify the restTemplate.getForObject() method was called with the correct URL
        verify(restTemplate, times(1))
                .getForObject(eq("https://simple-script-dinosaur-scrapping-production.up.railway.app/getAllDinoList"),
                        eq(Dinosaur[].class));
    }

}

