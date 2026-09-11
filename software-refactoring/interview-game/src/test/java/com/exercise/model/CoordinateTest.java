package com.exercise.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoordinateTest {

    @Test
    void testGoForward() {
        Coordinate coordinate = new Coordinate(1, 1);
        coordinate.goForward();
        Assertions.assertEquals(2, coordinate.getX());
        Assertions.assertEquals(1, coordinate.getY());
    }

    @Test
    void testGoBack() {
        Coordinate coordinate = new Coordinate(1, 1);
        coordinate.goBack();
        Assertions.assertEquals(0, coordinate.getX());
        Assertions.assertEquals(1, coordinate.getY());
    }

    @Test
    void testGoUp() {
        Coordinate coordinate = new Coordinate(1, 1);
        coordinate.goUp();
        Assertions.assertEquals(1, coordinate.getX());
        Assertions.assertEquals(2, coordinate.getY());
    }

    @Test
    void testGoDown() {
        Coordinate coordinate = new Coordinate(1, 1);
        coordinate.goDown();
        Assertions.assertEquals(1, coordinate.getX());
        Assertions.assertEquals(0, coordinate.getY());
    }
}
