package com.livecodingexercise.infra.repository;

public class BusTripModel {
    private Long id;
    private String departureStation;
    private String arrivalStation;
    private String busCompanyName;
    private Integer seats;
    private Integer priceMinorInEuros;

    public BusTripModel(Long id, String departureStation, String arrivalStation, String busCompanyName, Integer seats, Integer priceMinorInEuros) {
        this.id = id;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.busCompanyName = busCompanyName;
        this.seats = seats;
        this.priceMinorInEuros = priceMinorInEuros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public String getBusCompanyName() {
        return busCompanyName;
    }

    public void setBusCompanyName(String busCompanyName) {
        this.busCompanyName = busCompanyName;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getPriceMinorInEuros() {
        return priceMinorInEuros;
    }

    public void setPriceMinorInEuros(Integer priceMinorInEuros) {
        this.priceMinorInEuros = priceMinorInEuros;
    }
}
