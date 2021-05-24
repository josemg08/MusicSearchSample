package com.josegonzalez.musicsearchsample.model;

import java.util.ArrayList;
import java.util.List;

public class TrackListDto {

    private int resultCount;

    private List<TrackDto> results = new ArrayList<>();

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<TrackDto> getResults() {
        return results;
    }

    public void setResults(List<TrackDto> results) {
        this.results = results;
    }

}
