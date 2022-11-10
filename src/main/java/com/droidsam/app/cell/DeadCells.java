package com.droidsam.app.cell;

import java.util.Collection;
import java.util.stream.Stream;

public class DeadCells {
    private final Collection<DeadCell> cells;

    public DeadCells(Collection<DeadCell> cells) {
        this.cells = cells;
    }

    public Stream<DeadCell> stream() {
        return cells.stream();
    }
}
