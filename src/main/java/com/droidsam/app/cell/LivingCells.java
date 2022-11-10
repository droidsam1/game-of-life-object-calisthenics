package com.droidsam.app.cell;

import java.util.Collection;
import java.util.stream.Stream;

public class LivingCells {

    private final Collection<LiveCell> cells;

    public LivingCells(Collection<LiveCell> cells) {
        this.cells = cells;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LivingCells that = (LivingCells) o;

        return cells.equals(that.cells);
    }

    @Override
    public int hashCode() {
        return cells.hashCode();
    }

    public Stream<LiveCell> stream() {
        return cells.stream();
    }
}
