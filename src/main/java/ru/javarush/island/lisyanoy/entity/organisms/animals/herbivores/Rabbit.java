package ru.javarush.island.lisyanoy.entity.organisms.animals.herbivores;

import ru.javarush.island.lisyanoy.entity.organisms.Limit;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;
import ru.javarush.island.lisyanoy.entity.organisms.animals.Animal;

public class Rabbit extends Animal {

    public Rabbit(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }


    public static Organism create() {
        return new Rabbit("Кролик", "\uD83D\uDC07", 2,
                new Limit(2, 150, 2, 0.45));
    }

}
