package ru.javarush.island.lisyanoy.repository;

import ru.javarush.island.lisyanoy.entity.gameField.Cell;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;
import ru.javarush.island.lisyanoy.entity.organisms.animals.herbivores.*;
import ru.javarush.island.lisyanoy.entity.organisms.animals.predators.*;
import ru.javarush.island.lisyanoy.entity.organisms.plants.Plant;
import ru.javarush.island.lisyanoy.utils.DataEntity;
import ru.javarush.island.lisyanoy.utils.Rnd;

import java.util.*;

public class EntityFactory implements Factory{

    public static final int PERCENT_FILL = 30;
    public static final int PERCENT_PROBABLY_BORN = 50;
    private static final Class<?>[] TYPES;

    static {
        TYPES = new Class<?>[]{
                Bear.class,
                Boa.class,
                Eagle.class,
                Fox.class,
                Wolf.class,
                Boar.class,
                Buffalo.class,
                Caterpillar.class,
                Deer.class,
                Duck.class,
                Goat.class,
                Horse.class,
                Mouse.class,
                Rabbit.class,
                Sheep.class,
                Plant.class
        };
    }
    private static final Organism[] PROTOTYPES = DataEntity.prototypes(TYPES);

    public Cell createCells() {
        Map<String, Set<Organism>> residents = new HashMap<>();
        if (Rnd.get(PERCENT_FILL)) {
            for (Organism prototype : PROTOTYPES) {
                String type = prototype.getType();
                if (Rnd.get(PERCENT_PROBABLY_BORN)) {
                    residents.putIfAbsent(type, new HashSet<>());
                    Set<Organism> organisms = residents.get(prototype.getType());
                    int maxCountOrganisms = prototype.getLimit().maxCount() - organisms.size();
                    int countOrganisms = Rnd.random(0, maxCountOrganisms);
                    for (int i = 0; i < countOrganisms; i++) {
                        organisms.add(prototype.clone());
                    }
                }
            }
        }
        Cell cell = new Cell(residents);
        cell.setNextCell(new ArrayList<>());
        return cell;
    }

    public List<Organism> getPrototypes() {
        return Arrays.asList(PROTOTYPES);
    }
}
