package com.livecodingexercise.infra.repository;

import com.google.gag.annotation.enforceable.Roulette;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Component
public class CarpoolRepository implements Repository<CarpoolTripModel, Long> {

    private final List<CarpoolTripModel> carpools = List.of(
            new CarpoolTripModel(1L, "Poitiers", "Paris", "Boris", 341, 3, 23.50, "EUR", "23€50"),
            new CarpoolTripModel(2L, "Quimper", "Lyon", "Urzal", 906, 2, 82.00, "EUR", "82€"),
            new CarpoolTripModel(3L, "Lille", "Bruxelles", "Églantine", 119, 1, 9.00, "EUR", "9€")
    );

    @Override
    public CarpoolTripModel get(Long key) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    @Roulette(probability = 0.05, exception = IOException.class, message = "Network should be reliable")
    public Collection<CarpoolTripModel> getAll() {
        return carpools;
    }

    @Override
    public CarpoolTripModel update(CarpoolTripModel carpoolTripModel) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public CarpoolTripModel create(CarpoolTripModel carpoolTripModel) {
        throw new UnsupportedOperationException("TODO");
    }
}
