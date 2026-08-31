package com.exercise.model;

import java.util.HashMap;
import java.util.Map;

import static com.exercise.model.Direction.*;

public class Position {

    private int directionIndex;
    private Map<Integer, Direction> directionMap;
    private final Coordinate coordinate;

    public Position(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.directionIndex = direction.getIndex();
        initDirectionMap();
    }

    private void initDirectionMap() {
        this.directionMap = new HashMap<>();
        this.directionMap.put(E.getIndex(), E);
        this.directionMap.put(S.getIndex(), S);
        this.directionMap.put(W.getIndex(), W);
        this.directionMap.put(N.getIndex(), N);
    }

    // Change direction clockwise: E -> S -> W -> N
    public void turnDirectionRight() {
        if (directionIndex == N.getIndex()) {
            directionIndex = E.getIndex();
        } else {
            directionIndex++;
        }
    }

    public void turnDirectionLeft() {
        if (directionIndex == E.getIndex()) {
            directionIndex = N.getIndex();
        } else {
            directionIndex--;
        }
    }

    public Direction getDirection() {
        return directionMap.get(directionIndex);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return coordinate.getX() + " " + coordinate.getY() + " " + getDirection();
    }
}
