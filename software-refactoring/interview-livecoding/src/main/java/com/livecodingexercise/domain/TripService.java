package com.livecodingexercise.domain;

import com.livecodingexercise.infra.repository.BusRepository;
import com.livecodingexercise.infra.repository.CarpoolRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class TripService {

    private final CarpoolRepository carpoolRepository;
    private final BusRepository busRepository;

    // Spring is in charge of injecting the dependencies through the constructor
    public TripService(CarpoolRepository carpoolRepository, BusRepository busRepository) {
        this.carpoolRepository = carpoolRepository;
        this.busRepository = busRepository;
    }

    public SearchResults getTrips() {
        var carpoolResults = carpoolRepository.getAll()
                .stream()
                .map(model -> new SearchResult(
                        model.getId(),
                        model.getDeparture(),
                        model.getArrival(),
                        model.getDriverName(),
                        model.getDistance(),
                        model.getPriceAmount(),
                        model.getPriceCurrency(),
                        model.getFormattedPrice()
                ))
                .collect(Collectors.toUnmodifiableList());
        var busResults = busRepository.getAll()
                .stream()
                .map(model -> new SearchResult(
                        model.getId(),
                        model.getDepartureStation(),
                        model.getArrivalStation(),
                        model.getBusCompanyName(),
                        0,
                        model.getPriceMinorInEuros() / 100.,
                        "EUR",
                        String.format("%f€", model.getPriceMinorInEuros() / 100.0)
                ))
                .collect(Collectors.toUnmodifiableList());

        var searchResults = new SearchResults();
        searchResults.setResults(new ArrayList<>());
        searchResults.getResults().addAll(carpoolResults);
        searchResults.getResults().addAll(busResults);
        return searchResults;
    }
}
