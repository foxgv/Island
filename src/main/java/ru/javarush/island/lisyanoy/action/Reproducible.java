package ru.javarush.island.lisyanoy.action;

import ru.javarush.island.lisyanoy.entity.gameField.Cell;

public interface Reproducible {

    void spawn(Cell currentCell);
}
