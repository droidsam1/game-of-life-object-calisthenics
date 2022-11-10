package com.droidsam.app;

public class DeadCell implements Cell {
    private final Coordinate coordinate;

    private DeadCell(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public static DeadCell in(Coordinate coordinate) {
        return new DeadCell(coordinate);
    }

    @Override
    public Coordinate getPosition() {
        return null;
    }
}
