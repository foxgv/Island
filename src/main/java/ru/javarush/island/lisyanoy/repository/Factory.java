package ru.javarush.island.lisyanoy.repository;

import ru.javarush.island.lisyanoy.entity.gameField.Cell;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;

import java.util.List;

public interface Factory {
    Cell createCells();

    List<Organism> getPrototypes();
}
