package ru.javarush.island.lisyanoy.entity.organisms.plants;

import ru.javarush.island.lisyanoy.entity.gameField.Cell;
import ru.javarush.island.lisyanoy.entity.organisms.Limit;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Plant extends Organism {

    public Plant(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    public static Organism create() {
        return new Plant("Трава", "\uD83C\uDF3F", 1,
                new Limit(1, 200, 0, 0));
    }

    @Override
    public void spawn(Cell cell) {
        Cell nextCell = cell.getNextCells(1);
        safePlantSpawn(nextCell);
    }

    private void safePlantSpawn(Cell cell) {
        cell.getLock().lock();
        try {
            Map<String, Set<Organism>> residents = cell.getResidents();
            Set<Organism> organisms = residents.get(getType());
            if (Objects.nonNull(organisms) && organisms.contains(clone())) {
                organisms.add(clone());
            }
        } finally {
            cell.getLock().unlock();
        }
    }
}
