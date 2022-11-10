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

    private Cells(Map<Coordinate, Cell> cellGrid) {
        this.cellGrid = cellGrid;
    }

    public Cell getAt(Coordinate coordinate) {
        return Optional.ofNullable(cellGrid.get(coordinate)).orElse(DeadCell.in(coordinate));
    }

    public Cells applyRules() {
        var newGenerationGrid = new HashMap<Coordinate, Cell>();

        for (Map.Entry<Coordinate, Cell> entry : cellGrid.entrySet()) {

            long neighbors = getNumberOfNeighbors(entry.getKey());
            Cell newCellState = (neighbors == 2 || neighbors == 3) ? LiveCell.in(entry.getKey()) : DeadCell.in(entry.getKey());
            newGenerationGrid.put(entry.getKey(), newCellState);
        }

        if (cellGrid.size() <= 2) {
            return new Cells();
        }
        return new Cells(newGenerationGrid);
    }

    private long getNumberOfNeighbors(Coordinate coordinate) {
        return cellGrid.entrySet().stream().filter(coordinateCellEntry -> itsLivingANeighbor(coordinateCellEntry, coordinate)).count();
    }

    private boolean itsLivingANeighbor(Map.Entry<Coordinate, Cell> entry, Coordinate coordinate) {
        return entry.getKey().isNeighbor(coordinate) && entry.getValue() instanceof LiveCell;
    }
}
