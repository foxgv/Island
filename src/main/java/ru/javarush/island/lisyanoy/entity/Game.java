package ru.javarush.island.lisyanoy.entity;

import ru.javarush.island.lisyanoy.entity.gameField.GameField;
import ru.javarush.island.lisyanoy.repository.Factory;
import ru.javarush.island.lisyanoy.view.View;

public record Game(GameField gameField, Factory entityFactory, View view) {
}
