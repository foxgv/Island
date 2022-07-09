package ru.javarush.island.lisyanoy.services;

import ru.javarush.island.lisyanoy.entity.gameField.Cell;
import ru.javarush.island.lisyanoy.entity.gameField.GameField;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;
import ru.javarush.island.lisyanoy.entity.organisms.animals.Animal;

import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OrganismWorker implements Runnable {

    private final Organism prototype;
    private final GameField gameField;
    private final Queue<Task> tasks = new ConcurrentLinkedQueue<>();

    public OrganismWorker(Organism prototype, GameField gameField) {
        this.prototype = prototype;
        this.gameField = gameField;
    }

    @Override
    public void run() {
        Cell[][] cells = gameField.getCells();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                String type = prototype.getType();
                Set<Organism> organisms = cell.getResidents().get(type);
                if (Objects.nonNull(organisms)) {
                    cell.getLock().lock();
                    try {
                        for (Organism organism : organisms) {
                            Task task = new Task(organism, o -> {
                                o.spawn(cell);
                                if (organism instanceof Animal animal) {
                                    animal.eat(cell);
                                    animal.move(cell);
                                }
                            });
                            tasks.add(task);
                        }
                    } finally {
                        cell.getLock().unlock();
                    }
                    for (Task task : tasks) {
                        task.run();
                    }
                    tasks.clear();
                }

            }
        }
    }
}