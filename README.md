# Conway's Game of Life (Java)

A console-based implementation of Conway's Game of Life in Java.

## Description

The grid is stored as a two-dimensional integer array (`int[width][length]`).
Each cell is either alive (1) or dead (0).

The four rules are applied each generation:
- A live cell with 2 or 3 neighbors survives
- A live cell with fewer than 2 neighbors dies (underpopulation)
- A live cell with more than 3 neighbors dies (overpopulation)
- A dead cell with exactly 3 neighbors becomes alive (reproduction)

## How to Run

1. Open the project in Eclipse or VS Code
2. Run `GameOfLife.java`
