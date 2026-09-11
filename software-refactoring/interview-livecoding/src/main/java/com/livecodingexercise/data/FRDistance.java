package com.livecodingexercise.data;

import java.util.Map;

import static java.util.Map.entry;

final class FRDistance implements DistanceRepository {

    static Map<String, Map<String, Integer>> distances = Map.ofEntries(
        entry("Paris", Map.of(
            "Lille", 217,
            "Strasbourg", 487,
            "Poitiers", 340
        )),

        entry("Lille", Map.of(
            "Arras", 44,
            "Roubaix", 10,
            "Poitiers", 557,
            "Bailleul", 26,
            "Strasbourg", 549
        )),

        entry("Arras", Map.of(
            "Lille", 44,
            "Plailly", 128
        )),

        entry("Tourcoing", Map.of(
            "Lille", 11
        ))
    );

    @Override
    public Map<String, Map<String, Integer>> getDistances() {
        return distances;
    }
}