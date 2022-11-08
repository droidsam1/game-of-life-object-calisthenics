package com.droidsam.app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Cells {
    private final Map<Coordinate, Cell> cellGrid;

    public Cells() {
        this.cellGrid = new HashMap<>();
    }

    public Cells(Cell[] in) {
        this.cellGrid = Arrays.stream(in).collect(Collectors.toMap(Cell::getPosition, Function.identity()));
    }

    public Cell getAt(Coordinate coordinate) {
        return Optional.ofNullable(cellGrid.get(coordinate)).orElse(new DeadCell());
    }

    public Cells applyRules() {
        if (cellGrid.size() <= 2) {
            return new Cells();
        }
        return this;
    }
}
