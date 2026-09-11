package com.livecodingexercise.infra.repository;

public class CarpoolTripModel {

    private Long id;
    private String departure;
    private String arrival;
    private String driverName;
    private Integer distance;
    private Integer seats;

    // Should we keep the price?
    // It is intended to test if the candidate can detect duplication: price & formatterPrice
    private Double priceAmount;
    private String priceCurrency;
    private String formattedPrice;

    public CarpoolTripModel(Long id, String departure, String arrival, String driverName, Integer distance, Integer seats, Double priceAmount, String priceCurrency, String formattedPrice) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.driverName = driverName;
        this.distance = distance;
        this.seats = seats;
        this.priceAmount = priceAmount;
        this.priceCurrency = priceCurrency;
        this.formattedPrice = formattedPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Double getPriceAmount() {
        return priceAmount;
    }

    public void setPriceAmount(Double priceAmount) {
        this.priceAmount = priceAmount;
    }

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    public String getFormattedPrice() {
        return formattedPrice;
    }

    public void setFormattedPrice(String formattedPrice) {
        this.formattedPrice = formattedPrice;
    }
}
