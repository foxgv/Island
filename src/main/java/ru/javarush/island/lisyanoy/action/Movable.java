package ru.javarush.island.lisyanoy.action;

import ru.javarush.island.lisyanoy.entity.gameField.Cell;

public interface Movable {

    void move(Cell startCell);
}
