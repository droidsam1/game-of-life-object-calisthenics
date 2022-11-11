package com.droidsam.app;

import com.droidsam.app.cell.LiveCell;

public class PattersFixture {

    public static final Seed STILL_LIFE_BLOCK_PATTERN = new Seed(LiveCell.in(0, 0), LiveCell.in(0, 1), LiveCell.in(1, 0), LiveCell.in(1, 1));

    public static final Seed STILL_LIFE_BEE_HIVE = new Seed(LiveCell.in(0, 1), LiveCell.in(1, 0), LiveCell.in(2, 0), LiveCell.in(3, 1), LiveCell.in(1, 2), LiveCell.in(2, 2));

    public static final Seed OSCILLATOR_WITH_PERIOD_2 = new Seed(LiveCell.in(0, 1), LiveCell.in(1, 1), LiveCell.in(2, 1));


}
