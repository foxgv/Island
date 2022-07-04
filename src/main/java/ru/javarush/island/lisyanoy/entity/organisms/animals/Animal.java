package ru.javarush.island.lisyanoy.entity.organisms.animals;

import ru.javarush.island.lisyanoy.action.Movable;
import ru.javarush.island.lisyanoy.entity.gameField.Cell;
import ru.javarush.island.lisyanoy.entity.organisms.Limit;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;

import java.lang.reflect.Type;
import java.util.*;

public abstract class Animal extends Organism implements Movable {

    public Animal(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    @Override
    public void move(Cell startCell) {
        List<Cell> cel = startCell.getNextCell();
        Optional<Cell> found = Optional.empty();
        for (Cell cell : cel) {
            found = Optional.of(cell);
            break;
        }
        Cell nextCell = found.get();
        remove(startCell);
        add(nextCell);
    }

    private void remove(Cell cell) {
        cell.getLock().lock();
        try {
            cell.getResidents().get(this.getClass()).remove(this);
        } finally {
            cell.getLock().unlock();
        }
    }

    private void add(Cell cell) {
        cell.getLock().lock();
        try {
            cell.getResidents().get(this.getClass()).add(this);
        } finally {
            cell.getLock().unlock();
        }
    }
    @Override
    public void spawn(Cell currentCell) {
        Type type = this.getClass();
        Map<Type, Set<Organism>> residents = currentCell.getResidents();
        Set<Organism> organisms = residents.get(type);
        if (Objects.nonNull(organisms) && organisms.contains(this) && organisms.size() > 2) {
            currentCell.getLock().lock();
            try {
                currentCell.getResidents().get(this.getClass()).add(this.clone());
            } finally {
                currentCell.getLock().unlock();
            }
        }
    }
}
