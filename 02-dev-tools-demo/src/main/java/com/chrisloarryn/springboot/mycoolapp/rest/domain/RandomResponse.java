package com.chrisloarryn.springboot.mycoolapp.rest.domain;

public class RandomResponse {
    // return data which is a generic object and results which is an Integer
    private Object data;
    private Integer results;

    public RandomResponse() {
    }

    public RandomResponse(Object data, Integer results) {
        this.data = data;
        this.results = results;
    }

    public Object getData() {
        return data;
    }

    public Integer getResults() {
        return results;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setResults(Integer results) {
        this.results = results;
    }
}
