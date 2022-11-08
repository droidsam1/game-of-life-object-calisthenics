package com.droidsam.app;

public class GameOfLife {

    private final Cells cells;

    public GameOfLife() {
        this.cells = new Cells();
    }

    public GameOfLife(Seed seed) {
        this.cells = seed.getCells();
    }

    public Cells getCells() {
        return cells;
    }
}
