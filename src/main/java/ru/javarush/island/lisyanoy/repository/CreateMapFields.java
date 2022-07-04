package ru.javarush.island.lisyanoy.repository;

import ru.javarush.island.lisyanoy.entity.gameField.Cell;
import ru.javarush.island.lisyanoy.entity.gameField.GameField;

public class CreateMapFields {
    private final Factory entityFactory;

    public CreateMapFields(Factory entityFactory) {
        this.entityFactory = entityFactory;
    }

    public GameField createRandomFieldsMap(int rows, int cols) {
        GameField gameField = new GameField(rows, cols);
        Cell[][] cells = gameField.getCells();
        for (int i = 0; i < gameField.getRows(); i++) {
            for (int j = 0; j < gameField.getCols(); j++) {
                cells[i][j] = entityFactory.createRandomCell();
            }
        }
        return gameField;
    }
}
