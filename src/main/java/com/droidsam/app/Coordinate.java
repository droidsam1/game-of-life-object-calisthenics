package com.droidsam.app;

import java.util.Objects;

public class Coordinate {

    public final int x;
    public final int y;

    private Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinate of(int x, int y) {
        return new Coordinate(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public boolean isNeighbor(Coordinate coordinate) {
        if (this.equals(coordinate)) {
            return false;
        }
        if (Math.abs(coordinate.x - this.x) <= 1 && coordinate.y == this.y) {
            return true;
        }
        return Math.abs(coordinate.y - this.y) <= 1 && coordinate.x == this.x;
    }

    @Override
    public String toString() {
        return "Coordinate{" + "x=" + x + ", y=" + y + '}';
    }
}
