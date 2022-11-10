package com.droidsam.app;

import com.droidsam.app.cell.Cell;
import com.droidsam.app.cell.LivingCells;

public class GameOfLife {

    private Universe universe;

    public GameOfLife() {
        this.universe = Universe.empty();
    }

    public GameOfLife(Seed seed) {
        this.universe = Universe.createFrom(seed.getInitialPattern());
    }

    public LivingCells getLivingCells() {
        return universe.getLivingCells();
    }

    public void tick() {
        this.universe = this.universe.applyRules();
    }

    public Cell getCellAt(Coordinate coordinate) {
        return universe.getAt(coordinate);
    }
}
