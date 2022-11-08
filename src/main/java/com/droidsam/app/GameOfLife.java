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
        this.cells = new Cells();
    }
}
