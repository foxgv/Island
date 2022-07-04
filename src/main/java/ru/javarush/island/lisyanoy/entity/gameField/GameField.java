package ru.javarush.island.lisyanoy.entity.gameField;

public class GameField {
    public static final int MAP_ROWS = 100;
    public static final int MAP_COLS = 20;
    private final Cell[][] cells;

    public GameField(int rows, int cols) {
        this.cells = new Cell[rows][cols];
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getRows() {
        return cells.length;
    }

    public int getCols() {
        return cells[0].length;
    }
}
