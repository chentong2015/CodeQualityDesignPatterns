package com.exercise.io;

/**
 * File line validator according to the format and content of file input
 */
public class LineValidator {

    private static final String LINE_SPACE = " ";

    // Set private constructor for a helper class
    private LineValidator() {
    }

    public static boolean isValidBorderCoordinate(String line) {
        if (line == null || !line.contains(" ") || line.split(LINE_SPACE).length != 2) {
            return false;
        }
        String[] strings = line.split(LINE_SPACE);
        try {
            Integer.parseInt(strings[0]);
            Integer.parseInt(strings[1]);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isValidInitPosition(String line) {
        if (line == null || !line.contains(" ") || line.split(LINE_SPACE).length != 3) {
            return false;
        }
        String[] strings = line.split(LINE_SPACE);
        try {
            Integer.parseInt(strings[0]);
            Integer.parseInt(strings[1]);
        } catch (NumberFormatException nfe) {
            return false;
        }
        String direction = strings[2];
        return direction.equals("N") || direction.equals("E") || direction.equals("W") || direction.equals("S");
    }

    public static boolean isValidOrders(String line) {
        if (line == null || line.isEmpty()) {
            return false;
        }
        for (char c: line.toCharArray()) {
            if (c != 'G' && c != 'D' && c != 'A') {
                return false;
            }
        }
        return true;
    }
}
