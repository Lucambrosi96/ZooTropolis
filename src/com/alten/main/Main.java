package com.alten.main;

import com.alten.game.model.Player;
import com.alten.game.controller.GameController;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Vincent", 10);

        GameController gameController = new GameController(player);
        gameController.populateGame();
        gameController.runGame();
    }
}