package ru.javarush.island.lisyanoy.entity.organisms.animals.herbivores;

import ru.javarush.island.lisyanoy.entity.organisms.Limit;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;
import ru.javarush.island.lisyanoy.entity.organisms.animals.Animal;

public class Sheep extends Animal {

    public Sheep(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }


    public static Organism create() {
        return new Sheep("Овца", "\uD83D\uDC11", 70,
                new Limit(70, 140, 3, 15));
    }

}
