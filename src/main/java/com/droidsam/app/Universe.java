package com.droidsam.app;

import com.droidsam.app.cell.Cell;
import com.droidsam.app.cell.DeadCell;
import com.droidsam.app.cell.LiveCell;
import com.droidsam.app.cell.LivingCells;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Universe {
    private final Map<Coordinate, Cell> cellGrid;

    private Universe() {
        this.cellGrid = new HashMap<>();
    }

    public Universe(LivingCells in) {
        this.cellGrid = in.stream().collect(Collectors.toMap(Cell::getPosition, Function.identity()));
    }

    private Universe(Map<Coordinate, Cell> cellGrid) {
        this.cellGrid = cellGrid;
    }

    public static Universe empty() {
        return new Universe();
    }

    public Cell getAt(Coordinate coordinate) {
        return Optional.ofNullable(cellGrid.get(coordinate)).orElse(DeadCell.in(coordinate));
    }

    public Universe applyRules() {
        var newGenerationGrid = new HashMap<Coordinate, Cell>();
        processLiveCells(newGenerationGrid);
        processDeadCells(newGenerationGrid);
        return new Universe(newGenerationGrid);
    }

    private void processLiveCells(HashMap<Coordinate, Cell> newGenerationGrid) {
        for (Map.Entry<Coordinate, Cell> entry : cellGrid.entrySet()) {
            long neighbors = getNumberOfNeighbors(entry.getKey());
            Cell newCellState = (neighbors == 2 || neighbors == 3) ? LiveCell.in(entry.getKey()) : DeadCell.in(entry.getKey());
            newGenerationGrid.put(entry.getKey(), newCellState);
        }
    }

    private void processDeadCells(Map<Coordinate, Cell> newGeneration) {

        for (Coordinate coordinate : getSurroundingDeadCells()) {
            long neighbors = getNumberOfNeighbors(coordinate);
            if (neighbors == 3) {
                newGeneration.put(coordinate, LiveCell.in(coordinate));
            }
        }

    }

    private Set<Coordinate> getSurroundingDeadCells() {
        var coordinatesUp = this.cellGrid.keySet().stream().map(c -> Coordinate.of(c.x, c.y + 1)).collect(Collectors.toSet());
        var coordinatesDown = this.cellGrid.keySet().stream().map(c -> Coordinate.of(c.x, c.y - 1)).collect(Collectors.toSet());
        var coordinatesRight = this.cellGrid.keySet().stream().map(c -> Coordinate.of(c.x + 1, c.y)).collect(Collectors.toSet());
        var coordinatesLeft = this.cellGrid.keySet().stream().map(c -> Coordinate.of(c.x - 1, c.y)).collect(Collectors.toSet());


        var surroundings = new java.util.HashSet<Coordinate>();
        surroundings.addAll(coordinatesUp);
        surroundings.addAll(coordinatesDown);
        surroundings.addAll(coordinatesRight);
        surroundings.addAll(coordinatesLeft);
        surroundings.removeAll(this.cellGrid.keySet());
        return surroundings;
    }

    private long getNumberOfNeighbors(Coordinate coordinate) {
        return cellGrid.entrySet().stream().filter(coordinateCellEntry -> itsLivingANeighbor(coordinateCellEntry, coordinate)).count();
    }

    private boolean itsLivingANeighbor(Map.Entry<Coordinate, Cell> entry, Coordinate coordinate) {
        return entry.getKey().isNeighbor(coordinate) && entry.getValue() instanceof LiveCell;
    }

    public LivingCells getLivingCells() {
        return new LivingCells(cellGrid.values().stream().filter(LiveCell.class::isInstance).map(LiveCell.class::cast).collect(Collectors.toList()));
    }
}
