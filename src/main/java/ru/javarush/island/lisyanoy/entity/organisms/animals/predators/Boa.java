package ru.javarush.island.lisyanoy.entity.organisms.animals.predators;

import ru.javarush.island.lisyanoy.entity.organisms.Limit;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;
import ru.javarush.island.lisyanoy.entity.organisms.animals.Animal;

public class Boa extends Animal {
    public Boa(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    public static Organism create() {
        return new Boa("Удав", "\uD83D\uDC0D", 15, new Limit(15, 30, 1, 3));
    }
}
