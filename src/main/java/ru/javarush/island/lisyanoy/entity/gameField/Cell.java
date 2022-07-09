package ru.javarush.island.lisyanoy.entity.gameField;

import ru.javarush.island.lisyanoy.entity.organisms.Organism;
import ru.javarush.island.lisyanoy.utils.Rnd;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {
    private final Map<String, Set<Organism>> residents;
    private List<Cell> nextCell;
    private final Lock lock = new ReentrantLock(true);

    public Lock getLock() {
        return lock;
    }

    public Cell(Map<String, Set<Organism>> residents) {
        this.residents = residents;
    }

    public Map<String, Set<Organism>> getResidents() {
        return residents;
    }

    public void setNextCell(List<Cell> nextCell) {
        this.nextCell = nextCell;
    }

    public List<Cell> getNextCell() {
        return nextCell;
    }
    public Cell getNextCells(int countStep) {
        Cell current = this;
        for (int i = 0; i < countStep; i++) {
            List<Cell> nextCells = current.nextCell;
            int direction = Rnd.random(0,nextCells.size() - 1);
            current = nextCells.get(direction);
        }
        return current;
    }
}
