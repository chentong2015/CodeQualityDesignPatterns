package com.livecodingexercise.application.search;

import java.util.List;

public class SearchResponse {

    public SearchResponse(List<TripResponse> trips) {
        this.trips = trips;
    }

    public List<TripResponse> trips;

    public static class TripResponse {

        public TripResponse(String id, String departure, String arrival, String formattedPrice, String driverName) {
            this.id = id;
            this.departure = departure;
            this.arrival = arrival;
            this.formattedPrice = formattedPrice;
            this.driverName = driverName;
        }

        public String id;
        public String departure;
        public String arrival;
        public String formattedPrice;
        public String driverName;
    }
}
