package ru.javarush.island.lisyanoy.utils;

import java.util.concurrent.ThreadLocalRandom;

public class Rnd {
    public static int random(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static boolean get(int percentProbably){
        return random(0, 100) < percentProbably;
    }
}
