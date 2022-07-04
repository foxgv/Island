package ru.javarush.island.lisyanoy.entity.organisms.plants;

import ru.javarush.island.lisyanoy.entity.gameField.Cell;
import ru.javarush.island.lisyanoy.entity.organisms.Limit;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;
import ru.javarush.island.lisyanoy.entity.organisms.animals.predators.Wolf;

public class Plant extends Organism {
    public Plant(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    public static Organism create() {
        return new Wolf("Трава", "\u2F8B", 1, new Limit(200, 0, 0, 0));
    }

    @Override
    public void spawn(Cell currentCell) {

    }
}
