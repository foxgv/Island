package ru.javarush.island.lisyanoy;


import ru.javarush.island.lisyanoy.entity.Game;
import ru.javarush.island.lisyanoy.entity.gameField.GameField;
import ru.javarush.island.lisyanoy.repository.CreateMapFields;
import ru.javarush.island.lisyanoy.repository.EntityFactory;
import ru.javarush.island.lisyanoy.repository.Factory;
import ru.javarush.island.lisyanoy.services.GameWorker;
import ru.javarush.island.lisyanoy.view.ConsoleView;

public class ConsoleRunner {
    public static void main(String[] args) {

        Factory entityFactory = new EntityFactory();
        CreateMapFields createMapFields = new CreateMapFields(entityFactory);
        GameField gameField = createMapFields.createRandomFieldsMap(GameField.MAP_ROWS, GameField.MAP_COLS);
        ConsoleView view = new ConsoleView(gameField);
        Game game = new Game(gameField, entityFactory, view);
        GameWorker gameWorker = new GameWorker(game);
        gameWorker.start();
    }
}
