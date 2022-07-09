package ru.javarush.island.lisyanoy.entity.organisms.animals.herbivores;

import ru.javarush.island.lisyanoy.entity.organisms.Limit;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;
import ru.javarush.island.lisyanoy.entity.organisms.animals.Animal;

public class Duck extends Animal {

    public Duck(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }


    public static Organism create() {
        return new Duck("Утка", "\uD83E\uDD86", 1,
                new Limit(1, 200, 4, 0.15));
    }

}
