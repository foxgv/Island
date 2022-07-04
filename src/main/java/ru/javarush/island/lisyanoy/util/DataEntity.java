package ru.javarush.island.lisyanoy.util;

import ru.javarush.island.lisyanoy.entity.organisms.Organism;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DataEntity {

    public static Organism[] prototypes(Class<?>[] TYPES) {
        Organism[] organisms = new Organism[TYPES.length];
        for (int i = 0; i < organisms.length; i++) {
            try {
                Method method = TYPES[i].getDeclaredMethod("create");
                organisms[i] = (Organism) method.invoke(TYPES.getClass());
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return organisms;
    }
}
