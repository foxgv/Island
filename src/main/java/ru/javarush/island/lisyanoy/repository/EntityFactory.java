package ru.javarush.island.lisyanoy.repository;

import ru.javarush.island.lisyanoy.entity.gameField.Cell;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;
import ru.javarush.island.lisyanoy.entity.organisms.animals.herbivores.*;
import ru.javarush.island.lisyanoy.entity.organisms.animals.predators.*;
import ru.javarush.island.lisyanoy.util.DataEntity;
import ru.javarush.island.lisyanoy.util.Rnd;

import java.lang.reflect.Type;
import java.util.*;

public class EntityFactory implements Factory{

    public static final int PERCENT_FILL = 33;
    public static final int PERCENT_PROBABLY_BORN = 50;
    private static final Class<?>[] TYPES;

    static {
        TYPES = new Class<?>[]{
                Bear.class,
                Boa.class,
                Eagle.class,
                Fox.class,
                Wolf.class,
                Bear.class,
                Boar.class,
                Buffalo.class,
                Caterpillar.class,
                Deer.class,
                Duck.class,
                Goat.class,
                Horse.class,
                Mouse.class,
                Rabbit.class,
                Sheep.class
        };
    }

    private static final Organism[] PROTOTYPES = DataEntity.prototypes(TYPES);
    

    @Override
    public Cell createRandomCell() {
        Map<Type, Set<Organism>> residents = new HashMap<>();
        boolean fill = Rnd.get(PERCENT_FILL);
        if (fill) {
            for (Organism prototype : PROTOTYPES) {
                Type type = prototype.getClass();
                boolean born = Rnd.get(PERCENT_PROBABLY_BORN);
                if (born) {
                    residents.putIfAbsent(type, new HashSet<>());
                    Set<Organism> organisms = residents.get(prototype.getClass());
                    int currentCount = organisms.size();
                    int max = prototype.getLimit().maxCount() - currentCount;
                    int count = Rnd.random(0, max);
                    for (int i = 0; i < count; i++) {
                        organisms.add(prototype.clone());
                    }
                }
            }
        }
        return new Cell(residents);
    }

    @Override
    public List<Organism> getAllPrototypes() {
        return Arrays.asList(PROTOTYPES);
    }
}
