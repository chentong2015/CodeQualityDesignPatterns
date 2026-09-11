package com.livecodingexercise.application.search;

import com.livecodingexercise.domain.TripService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchEndpoint {

    private final TripService tripService;

    public SearchEndpoint(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    SearchResponse search() {
        var searchResults = tripService.getTrips();
        return SearchResultMapper.map(searchResults);
    }
}
