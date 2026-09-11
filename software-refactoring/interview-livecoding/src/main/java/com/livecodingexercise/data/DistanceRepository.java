package com.livecodingexercise.data;

import java.util.Map;

interface DistanceRepository {

    Map<String, Map<String, Integer>> getDistances();
}