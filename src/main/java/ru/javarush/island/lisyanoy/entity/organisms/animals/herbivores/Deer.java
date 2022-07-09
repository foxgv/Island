package ru.javarush.island.lisyanoy.entity.organisms.animals.herbivores;

import ru.javarush.island.lisyanoy.entity.organisms.Limit;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;
import ru.javarush.island.lisyanoy.entity.organisms.animals.Animal;

public class Deer extends Animal {

    public Deer(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }


    public static Organism create() {
        return new Deer("Олень", "\uD83E\uDD8C", 300,
                new Limit(300, 20, 4, 50));
    }

}
