package com.chrisloarryn.springboot.mycoolapp.rest.domain;

public class ApiResponse {
    // has two keys with values: data and results. data has type array of Dinosaur and results has type Integer
    private Dinosaur[] data;
    private Integer results;

    public ApiResponse() {
    }

    public ApiResponse(Dinosaur[] data, Integer results) {
        this.data = data;
        this.results = results;
    }

    public Dinosaur[] getData() {
        return data;
    }

    public Integer getResults() {
        return results;
    }

    public void setData(Dinosaur[] data) {
        this.data = data;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

}
