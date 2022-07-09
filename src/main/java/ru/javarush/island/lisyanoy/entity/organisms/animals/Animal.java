package ru.javarush.island.lisyanoy.entity.organisms.animals;

import ru.javarush.island.lisyanoy.actions.Eating;
import ru.javarush.island.lisyanoy.actions.Movable;
import ru.javarush.island.lisyanoy.actions.Reproducible;
import ru.javarush.island.lisyanoy.entity.gameField.Cell;
import ru.javarush.island.lisyanoy.entity.organisms.Limit;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public abstract class Animal extends Organism implements Movable, Reproducible, Eating {
    public Animal(String name, String icon, double weight,
                  Limit limit) {
        super(name, icon, weight, limit);
    }

    @Override
    public void move(Cell startCell) {
        int maxSpeed = clone().getLimit().maxSpeed();
        Cell nextCell = startCell.getNextCells(maxSpeed);
        remove(startCell);
        add(nextCell);
    }

    private void add(Cell cell) {
        cell.getLock().lock();
        try {
            Set<Organism> set = cell.getResidents().get(getType());
                if(set.size() < getLimit().maxCount()){
                    set.add(clone());
                }
        } finally {
            cell.getLock().unlock();
        }
    }

    private void remove(Cell cell) {
        cell.getLock().lock();
        try {
            cell.getResidents().get(getType()).remove(clone());
        } finally {
            cell.getLock().unlock();
        }
    }

    @Override
    public void spawn(Cell cell) {
        cell.getLock().lock();
        try {
            Map<String, Set<Organism>> residents = cell.getResidents();
            Set<Organism> organisms = residents.get(getType());
            if (Objects.nonNull(organisms) && organisms.contains(clone()) && organisms.size() > 2) {
                cell.getResidents().get(getType()).add(clone());
            }
        } finally {
            cell.getLock().unlock();
        }
    }

    @Override
    public void eat(Cell cell) {

    }

}
