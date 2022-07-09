package ru.javarush.island.lisyanoy.entity.organisms.animals.herbivores;

import ru.javarush.island.lisyanoy.entity.organisms.Limit;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;
import ru.javarush.island.lisyanoy.entity.organisms.animals.Animal;

public class Horse extends Animal {

    public Horse(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }


    public static Organism create() {
        //return new Horse(Setting.HORSE_NAME, Setting.HORSE_ICON, Setting.HORSE_WEIGHT, new Limit(Setting.HORSE_MAX_WEIGHT, Setting.HORSE_MAX_COUNT, Setting.HORSE_MAX_SPEED, Setting.HORSE_MAX_FOOD));
        return new Horse("Лошадь", "\uD83D\uDC0E", 400,
                new Limit(400, 20, 4, 60));
    }

}
