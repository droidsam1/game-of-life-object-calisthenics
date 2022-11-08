package com.droidsam.app;

import java.util.ArrayList;
import java.util.List;

public class Cells {
    private final List<LiveCell> cells;

    public Cells() {
        this.cells = new ArrayList<>();
    }

    public Cells(LiveCell[] in) {
        this.cells = List.of(in);
    }
}
