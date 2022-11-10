# Game of Life

* This is part of my practice of exercises provided by the book _Agile Technical Practices Distilled_

Implement _Game of Life_ using object calisthenics plus everything we covered before.

For those no familiar with this game, here is a description adapted from Wikipedia:
https://en.wikipedia.org/wiki/Conway's_Game_of_Life

The universe of Game of Life is an infinite, two-dimensional orthogonal grid of square cells,
each of which is in one of two possible states: alive or dead (or populated and unpopulated, respectively).
Every cell interacts with is eight neighbors, which are the cells that are horizontally, vertically
or diagonally adjacent. At each step in time, the following transitions occur:

* Any live cell with fewer than two live neighbors dies, as if by underpopulation
* Any live cell with two or three live neighbors lives on to the next generation
* Any live cell with more than three live neighbors dies, asif by overpopulation
* Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction

The initial pattern constitutes the seed of the system.The first generation is created by applying the
previously mentioned rules simultaneously to every cell in the seed; births and deaths occur simultaneously
and the discrete moment at which this happens is sometimes called a tick. Each generation is a pure function of
the preceding one. The rules continue to be applied repeatedly to create further generations