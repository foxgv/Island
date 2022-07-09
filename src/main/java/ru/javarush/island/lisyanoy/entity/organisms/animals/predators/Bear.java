package ru.javarush.island.lisyanoy.entity.organisms.animals.predators;

import ru.javarush.island.lisyanoy.entity.organisms.Limit;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;
import ru.javarush.island.lisyanoy.entity.organisms.animals.Animal;

public class Bear extends Animal {
    public Bear(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    public static Organism create() {
        return new Bear("Медведь", "\uD83D\uDC3B", 500,
                new Limit(500, 5, 2, 80));
    }
}
