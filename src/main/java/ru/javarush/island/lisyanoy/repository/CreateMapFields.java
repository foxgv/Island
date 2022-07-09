package ru.javarush.island.lisyanoy.repository;

import ru.javarush.island.lisyanoy.entity.gameField.Cell;
import ru.javarush.island.lisyanoy.entity.gameField.GameField;

import java.util.List;

public class CreateMapFields {

    private final Factory entityFactory;


    public CreateMapFields(Factory entityFactory) {
        this.entityFactory = entityFactory;
    }

    public GameField createFieldsMap(int rows, int cols){
        GameField gameField = new GameField(rows, cols);
        Cell[][] cells = gameField.getCells();
        for (Cell[] cell : cells) {
            for (int i = 0; i < cell.length; i++) {
                cell[i] = entityFactory.createCells();
            }
        }
        for (int row = 0; row < gameField.getRows(); row++) {
            for (int col = 0; col < gameField.getCols(); col++) {
                List<Cell> nearCell = cells[row][col].getNextCell();
                if(row > 0) {
                    nearCell.add(cells[row - 1][col]);
                }
                if (col > 0) {
                    nearCell.add(cells[row][col - 1]);
                }
                if (row < gameField.getRows() - 1) {
                    nearCell.add(cells[row + 1][col]);
                }
                if (col < gameField.getCols() - 1) {
                    nearCell.add(cells[row][col + 1]);
                }
            }
        }
        return gameField;
    }

}
