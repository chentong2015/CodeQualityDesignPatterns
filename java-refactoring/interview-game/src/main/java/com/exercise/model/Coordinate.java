package com.exercise.model;

public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void goForward() {
        this.x++;
    }

    public void goBack() {
        this.x--;
    }

    public void goUp() {
        this.y++;
    }

    public void goDown() {
        this.y--;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
