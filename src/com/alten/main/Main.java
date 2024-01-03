package com.alten.main;

import com.alten.game.controller.GameController;

public class Main {
    public static void main(String[] args) {

        GameController gameController = GameController.getInstance();
        gameController.populateGame();
        gameController.runGame();
    }
}