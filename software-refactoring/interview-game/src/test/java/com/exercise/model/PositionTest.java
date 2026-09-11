package com.exercise.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void testTurnDirectionRight() {
        Coordinate coordinate = new Coordinate(0, 0);
        Position position = new Position(coordinate, Direction.E);
        position.turnDirectionRight();
        Assertions.assertEquals(Direction.S, position.getDirection());
    }

    @Test
    void testTurnDirectionLeft() {
        Coordinate coordinate = new Coordinate(0, 0);
        Position position = new Position(coordinate, Direction.E);
        position.turnDirectionLeft();
        Assertions.assertEquals(Direction.N, position.getDirection());
    }

    @Test
    void testPositionToString() {
        Coordinate coordinate = new Coordinate(0, 0);
        Position position = new Position(coordinate, Direction.E);
        Assertions.assertEquals("0 0 E", position.toString());
    }
}
