package ru.javarush.island.lisyanoy.services;

import ru.javarush.island.lisyanoy.entity.gameField.Cell;
import ru.javarush.island.lisyanoy.entity.gameField.GameField;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;
import ru.javarush.island.lisyanoy.entity.organisms.animals.Animal;

import java.lang.reflect.Type;
import java.util.Set;

public class OrganismWorker implements Runnable {
    private final Organism prototype;
    private final GameField gameField;

    public OrganismWorker(Organism prototype, GameField gameField) {
        this.prototype = prototype;
        this.gameField = gameField;
    }

    @Override
    public void run() {
        Cell[][] cells = gameField.getCells();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                Type type = prototype.getClass();
                Set<Organism> organisms = cell.getResidents().get(type);
                for (Organism organism : organisms) {
                    if (organism instanceof Animal animal) {
                        animal.move(cell);
                    } else {
                        prototype.spawn(cell);
                    }
                }
            }
        }
    }
}
