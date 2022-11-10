package com.droidsam.app;

import com.droidsam.app.cell.LiveCell;
import com.droidsam.app.cell.LivingCells;

import java.util.Collection;
import java.util.List;

public class Seed {

    private final Collection<LiveCell> initialPattern;

    public Seed(LiveCell... in) {
        this.initialPattern = List.of(in);
    }

    public LivingCells getInitialPattern() {
        return new LivingCells(initialPattern);
    }
}
