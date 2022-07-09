package ru.javarush.island.lisyanoy.services;

import ru.javarush.island.lisyanoy.entity.Game;
import ru.javarush.island.lisyanoy.entity.organisms.Organism;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameWorker extends Thread {
    public static final int PERIOD = 1000;
    private final Game game;

    public GameWorker(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);

        List<OrganismWorker> workers = new ArrayList<>();
        for (Organism o : game.entityFactory().getPrototypes()) {
            OrganismWorker organismWorker = new OrganismWorker(o, game.gameField());
            workers.add(organismWorker);
        }
        executorService.scheduleAtFixedRate(() -> {
            ExecutorService servicePool = Executors.newFixedThreadPool(4);
            for (OrganismWorker worker : workers) {
                servicePool.submit(worker);
            }
            servicePool.shutdown();
            try {
                if (servicePool.awaitTermination(PERIOD, TimeUnit.MILLISECONDS)) {
                    game.consoleView().showMap();
                    game.consoleView().showAllOrganisms();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, PERIOD, PERIOD, TimeUnit.MILLISECONDS);
    }
}
