package com.droidsam.app;

public class LiveCell {
    private final int x;
    private final int y;

    private LiveCell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static LiveCell in(int x, int y) {
        return new LiveCell(x, y);
    }
}
