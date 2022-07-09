package ru.javarush.island.lisyanoy.entity.organisms.animals.herbivores;

import ru.javarush.island.lisyanoy.entity.organisms.Limit;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;
import ru.javarush.island.lisyanoy.entity.organisms.animals.Animal;

public class Caterpillar extends Animal {

    public Caterpillar(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }


    public static Organism create() {
        return new Caterpillar("Гусеница", "\uD83D\uDC1B", 0.01,
                new Limit(0.01, 1000, 0, 0));
    }

}
