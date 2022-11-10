package com.droidsam.app.cell;

import com.droidsam.app.Coordinate;

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
        return coordinate;
    }

    @Override
    public String toString() {
        return "DeadCell{" + "coordinate=" + coordinate + '}';
    }
}
