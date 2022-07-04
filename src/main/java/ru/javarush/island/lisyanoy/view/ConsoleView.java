package ru.javarush.island.lisyanoy.view;

import ru.javarush.island.lisyanoy.entity.gameField.Cell;
import ru.javarush.island.lisyanoy.entity.gameField.GameField;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ConsoleView implements View {

    private final GameField gameField;

    public ConsoleView(GameField gameField) {
        this.gameField = gameField;
    }

    @Override
    public String showMap() {
        Cell[][] cells = gameField.getCells();
        Map<String, Integer> map = new HashMap<>();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                Map<Type, Set<Organism>> residents = cell.getResidents();
                for (Set<Organism> resident : residents.values()) {
                    if (resident.size() > 0) {
                        Optional<Organism> found = Optional.empty();
                        for (Organism organism : resident) {
                            found = Optional.of(organism);
                            break;
                        }
                        map.put(found.get().getIcon() + "(" + found.get().getName() + ")", resident.size());
                    }
                }
                System.out.print(map);
                map.clear();
            }
            System.out.println();
        }
        System.out.println("\n" + "*".repeat(50) + "\n");
        return map.toString();

    }
}
