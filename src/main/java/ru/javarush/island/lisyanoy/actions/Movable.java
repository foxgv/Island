package ru.javarush.island.lisyanoy.actions;

import ru.javarush.island.lisyanoy.entity.gameField.Cell;

public interface Movable {
    void move(Cell startCell);
}
