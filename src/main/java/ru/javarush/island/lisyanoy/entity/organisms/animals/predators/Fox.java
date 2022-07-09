package ru.javarush.island.lisyanoy.entity.organisms.animals.predators;

import ru.javarush.island.lisyanoy.entity.organisms.Limit;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;
import ru.javarush.island.lisyanoy.entity.organisms.animals.Animal;

public class Fox extends Animal {
    public Fox(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    public static Organism create() {
        return new Fox("Лиса", "\uD83E\uDD8A", 8,
                new Limit(8, 30, 2, 2));
    }
}
