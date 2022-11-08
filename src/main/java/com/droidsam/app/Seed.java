package com.droidsam.app;

public class Seed {

    private final Cells cells;

    public Seed(LiveCell... in) {
        this.cells = new Cells(in);
    }

    public Cells getCells() {
        return cells;
    }
}
