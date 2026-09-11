package com.livecodingexercise.domain;

import java.util.List;

public class SearchResults {

    private Integer count = 0;
    private List<SearchResult> results;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<SearchResult> getResults() {
        return results;
    }

    public void setResults(List<SearchResult> results) {
        this.results = results;
    }
}
