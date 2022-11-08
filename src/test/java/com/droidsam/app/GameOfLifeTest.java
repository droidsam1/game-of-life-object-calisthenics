package com.droidsam.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameOfLifeTest {

    @Test
    public void theUniverseCanBeCreated() {
        var universe = new GameOfLife();
        Assertions.assertNotNull(universe);
    }

    @Test
    public void theUniverseCanBeSeeded() {
        var initialPattern = new Seed();
        var universe = new GameOfLife(initialPattern);
        Assertions.assertEquals(initialPattern.getCells(), universe.getCells());
    }

}
