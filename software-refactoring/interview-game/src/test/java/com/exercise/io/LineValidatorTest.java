package com.exercise.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LineValidatorTest {

    // Validate the first line for Border coordinate
    @Test
    void testIsValidBorderCoordinateOK() {
        String line = "5 5";
        Assertions.assertTrue(LineValidator.isValidBorderCoordinate(line));
    }

    @Test
    void testIsValidBorderCoordinateFailed() {
        String line = "5 a";
        Assertions.assertFalse(LineValidator.isValidBorderCoordinate(line));
    }

    // Validate the line for init position
    @Test
    void testisValidInitPositionOK() {
        String line = "1 2 N";
        Assertions.assertTrue(LineValidator.isValidInitPosition(line));
    }

    @Test
    void testisValidInitPositionFailed() {
        String line = "1 2 A";
        Assertions.assertFalse(LineValidator.isValidInitPosition(line));
    }

    // Validate the line for list of correct orders, for example "GAD"
    @Test
    void testIsValidOrdersOK() {
        String line = "GAGAGAGADA";
        Assertions.assertTrue(LineValidator.isValidOrders(line));
    }

    @Test
    void testIsValidOrdersFailed() {
        String line = "GAGAKAGADA";
        Assertions.assertFalse(LineValidator.isValidOrders(line));
    }
}
