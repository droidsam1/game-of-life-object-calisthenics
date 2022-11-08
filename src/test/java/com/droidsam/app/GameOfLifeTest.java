package com.droidsam.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameOfLifeTest {

    @Test
    public void theUniverseCanBeCreated() {
        Assertions.assertNotNull(new GameOfLife());
    }


    @Test
    public void theUniverseCanBeSeeded() {
        new GameOfLife(new Seed());
    }


}
