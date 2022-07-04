package ru.javarush.island.lisyanoy.entity.organisms.animals.predators;

import ru.javarush.island.lisyanoy.entity.organisms.Limit;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;
import ru.javarush.island.lisyanoy.entity.organisms.animals.Animal;

public class Wolf extends Animal {
    public Wolf(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    public static Organism create() {
        return new Wolf("Волк", "\uD83D\uDC3A", 50, new Limit(50, 30, 3, 8));
    }
}
