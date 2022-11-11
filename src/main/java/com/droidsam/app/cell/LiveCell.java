package com.droidsam.app.cell;

import com.droidsam.app.Coordinate;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LiveCell liveCell = (LiveCell) o;
        return coordinate.equals(liveCell.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }

    @Override
    public String toString() {
        return "LiveCell{" + "coordinate=" + coordinate + '}';
    }
}
