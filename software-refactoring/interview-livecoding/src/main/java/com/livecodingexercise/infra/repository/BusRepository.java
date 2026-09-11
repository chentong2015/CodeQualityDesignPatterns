package com.livecodingexercise.infra.repository;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class BusRepository implements Repository<BusTripModel, Long> {

    private final List<BusTripModel> busTrips = List.of(
            new BusTripModel(10L, "Paris-Bercy", "Lille-Flandres", "Les Cars du Nord", 55, 1500),
            new BusTripModel(10L, "Le Mans Université", "Laval", "Les Cars de l'Ouest", 50, 900),
            new BusTripModel(10L, "Nice — Sophia Antipolis", "Toulouse", "Les Cars du Sud", 30, 3500)
    );

    @Override
    public BusTripModel get(Long key) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Collection<BusTripModel> getAll() {
        return busTrips;
    }

    @Override
    public BusTripModel update(BusTripModel busTripModel) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public BusTripModel create(BusTripModel busTripModel) {
        throw new UnsupportedOperationException("TODO");
    }
}
