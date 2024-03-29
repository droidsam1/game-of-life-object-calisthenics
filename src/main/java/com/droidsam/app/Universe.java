package com.droidsam.app;

import com.droidsam.app.cell.Cell;
import com.droidsam.app.cell.DeadCell;
import com.droidsam.app.cell.LiveCell;
import com.droidsam.app.cell.LivingCells;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Universe {
    private final Map<Coordinate, Cell> cellGrid;

    private Universe() {
        this.cellGrid = new HashMap<>();
    }

    private Universe(Map<Coordinate, Cell> cellGrid) {
        this.cellGrid = cellGrid;
    }

    public static Universe createFrom(LivingCells in) {
        return new Universe(in.stream().collect(Collectors.toMap(Cell::getPosition, Function.identity())));
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
        newGeneration.putAll(getLivingCells().getSurroundingDeadCells().stream().map(DeadCell::getPosition).filter(c -> getNumberOfNeighbors(c) == 3).map(LiveCell::in).collect(Collectors.toMap(LiveCell::getPosition, Function.identity())));
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
