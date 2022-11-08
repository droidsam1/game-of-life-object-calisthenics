package com.droidsam.app;

public class GameOfLife {

    private Cells cells;

    public GameOfLife() {
        this.cells = new Cells();
    }

    public GameOfLife(Seed seed) {
        this.cells = seed.getCells();
    }

    public Cells getCells() {
        return cells;
    }

    public void tick() {
        this.cells = this.cells.applyRules();
    }

    public Cell getCellAt(Coordinate coordinate) {
        return cells.getAt(coordinate);
    }
}
