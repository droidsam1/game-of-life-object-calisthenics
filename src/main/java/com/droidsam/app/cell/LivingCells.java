package com.droidsam.app.cell;

import com.droidsam.app.Coordinate;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LivingCells {

    private final Collection<LiveCell> cells;

    public LivingCells(Collection<LiveCell> cells) {
        this.cells = cells;
    }

    public DeadCells getSurroundingDeadCells() {
        var livingCellsCoordinates = cells.stream().map(LiveCell::getPosition).collect(Collectors.toSet());

        var coordinatesUp = livingCellsCoordinates.stream().map(c -> Coordinate.of(c.x, c.y + 1)).collect(Collectors.toSet());
        var coordinatesDown = livingCellsCoordinates.stream().map(c -> Coordinate.of(c.x, c.y - 1)).collect(Collectors.toSet());
        var coordinatesRight = livingCellsCoordinates.stream().map(c -> Coordinate.of(c.x + 1, c.y)).collect(Collectors.toSet());
        var coordinatesLeft = livingCellsCoordinates.stream().map(c -> Coordinate.of(c.x - 1, c.y)).collect(Collectors.toSet());


        var surroundings = new java.util.HashSet<Coordinate>();
        surroundings.addAll(coordinatesUp);
        surroundings.addAll(coordinatesDown);
        surroundings.addAll(coordinatesRight);
        surroundings.addAll(coordinatesLeft);
        surroundings.removeAll(livingCellsCoordinates);
        return new DeadCells(surroundings.stream().map(DeadCell::in).collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LivingCells that = (LivingCells) o;

        return new HashSet<>(this.cells).equals(new HashSet<>(that.cells));
    }

    @Override
    public int hashCode() {
        return cells.hashCode();
    }

    public Stream<LiveCell> stream() {
        return cells.stream();
    }
}
