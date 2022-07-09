package ru.javarush.island.lisyanoy.view;

import ru.javarush.island.lisyanoy.entity.gameField.Cell;
import ru.javarush.island.lisyanoy.entity.gameField.GameField;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;

import java.util.*;

public class ConsoleView{
    private final GameField gameField;

    public ConsoleView(GameField gameField) {
        this.gameField = gameField;
    }

    public void showMap() {
        Cell[][] cells = gameField.getCells();
        Map<String, Integer> map = new HashMap<>();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                Map<String, Set<Organism>> residents = cell.getResidents();
                for (Set<Organism> set : residents.values()) {
                    for (Organism organism : set) {
                        map.put(organism.getIcon(), set.size());
                    }
                }
                System.out.print(map);
                map.clear();
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Game field: " + gameField.getRows() + "x" + gameField.getCols());
        System.out.println("Общая статистика:");
    }

    public void showAllOrganisms(){
        Map<String, Integer> statistics = new HashMap<>();
        Cell[][] cells = gameField.getCells();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                Map<String, Set<Organism>> residents = cell.getResidents();
                if (Objects.nonNull(residents)) {
                    for (Set<Organism> set : residents.values()) {
                        if (set.size() > 0) {
                            Optional<Organism> optionalOrganism = Optional.empty();
                            for (Organism organism : set) {
                                optionalOrganism = Optional.of(organism);
                                break;
                            }
                            String icon = optionalOrganism.get().getIcon();
                            statistics.put(icon, statistics.getOrDefault(icon, 0) + set.size());
                        }
                    }
                }
            }
        }
        Set<Map.Entry<String, Integer>> entries = statistics.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.print(entry + " ");
        }
        System.out.println();
        System.out.println("*".repeat(100));
        System.out.println();
    }


}
