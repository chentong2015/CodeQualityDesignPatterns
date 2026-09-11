package com.exercise.model;

public enum Direction {

    E(1), // East
    S(2), // South
    W(3), // West
    N(4); // North

    private final int index;

    Direction(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
