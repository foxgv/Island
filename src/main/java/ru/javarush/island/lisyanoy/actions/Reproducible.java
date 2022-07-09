package ru.javarush.island.lisyanoy.actions;

import ru.javarush.island.lisyanoy.entity.gameField.Cell;

@FunctionalInterface
public interface Reproducible {
    void spawn(Cell currentCell);
}
