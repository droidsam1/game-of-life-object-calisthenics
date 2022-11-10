package com.droidsam.app;

public class LiveCell implements Cell {


    private final Coordinate coordinate;

    private LiveCell(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public static LiveCell in(int x, int y) {
        return new LiveCell(Coordinate.of(x, y));
    }

    public static LiveCell in(Coordinate coordinate) {
        return new LiveCell(coordinate);
    }

    public Coordinate getPosition() {
        return coordinate;
    }

    @Override
    public String toString() {
        return "LiveCell{" + "coordinate=" + coordinate + '}';
    }
}
