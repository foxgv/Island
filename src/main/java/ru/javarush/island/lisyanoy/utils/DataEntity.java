package ru.javarush.island.lisyanoy.utils;

import ru.javarush.island.lisyanoy.entity.organisms.Organism;
import ru.javarush.island.lisyanoy.exception.ConfigException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DataEntity {

    public static Organism[] prototypes(Class<?>[] TYPES) {
        Organism[] organisms = new Organism[TYPES.length];
        try {
            for (int i = 0; i < organisms.length; i++) {
                Method declaredMethod = TYPES[i].getDeclaredMethod("create");
                organisms[i] = (Organism) declaredMethod.invoke(organisms[i]);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new ConfigException("not found organism", e);
        }
        return organisms;
    }
}
