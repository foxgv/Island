package ru.javarush.island.lisyanoy.entity.organisms.animals.predators;

import ru.javarush.island.lisyanoy.entity.organisms.Limit;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;
import ru.javarush.island.lisyanoy.entity.organisms.animals.Animal;

public class Eagle extends Animal {

    public Eagle(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }


    public static Organism create() {
        return new Eagle("Орел", "\uD83E\uDD85", 6,
                new Limit(6, 20, 3, 1));
    }

}
