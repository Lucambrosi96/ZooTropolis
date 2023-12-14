package com.alten.game.controller;

public class GoCommand {
    private final GameController gameController;

    public GoCommand(GameController gameController) {
        this.gameController = gameController;
    }

    public void run(String direction) {
        if (gameController.getCurrentRoom().checkDirection(direction)) {
            gameController.setCurrentRoom(gameController.getCurrentRoom().move(direction));
            gameController.getCurrentRoom().getInformation();
        } else {
            System.out.println("There is no room in that direction");
        }
    }
}