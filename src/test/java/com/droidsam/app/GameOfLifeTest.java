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

    @Test
    public void theUniverseCanBeSeededWithAInitialPattern() {
        var initialPattern = new Seed(LiveCell.in(0, 0), LiveCell.in(1, 1));
        var universe = new GameOfLife(initialPattern);
        Assertions.assertEquals(initialPattern.getCells(), universe.getCells());
    }

    @Test
    public void theUniverseCanStepInTime() {
        var initialPattern = new Seed(LiveCell.in(0, 0));
        var universe = new GameOfLife(initialPattern);

        universe.tick();

        Assertions.assertNotEquals(initialPattern.getCells(), universe.getCells());
    }

    @Test
    public void aLivingCellWithFewerThanNeighborsDiesByUnderPopulation() {
        var initialPattern = new Seed(LiveCell.in(0, 0));
        var universe = new GameOfLife(initialPattern);

        universe.tick();

        Assertions.assertInstanceOf(DeadCell.class, universe.getCellAt(Coordinate.of(0, 0)));
    }

    @Test
    public void aLivingCellWithTwoNeighborsLivesOnToTheNextGeneration() {
        var initialPattern = new Seed(LiveCell.in(0, 0), LiveCell.in(0, 1), LiveCell.in(1, 0));
        var universe = new GameOfLife(initialPattern);

        universe.tick();

        Assertions.assertInstanceOf(LiveCell.class, universe.getCellAt(Coordinate.of(0, 0)));
    }

    @Test
    public void aLivingCellWithThreeNeighborsLivesOnToTheNextGeneration() {
        var initialPattern = new Seed(LiveCell.in(1, 1), LiveCell.in(0, 1), LiveCell.in(1, 0), LiveCell.in(1, 2));
        var universe = new GameOfLife(initialPattern);

        universe.tick();

        Assertions.assertInstanceOf(LiveCell.class, universe.getCellAt(Coordinate.of(1, 1)));
    }

}
