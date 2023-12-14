package com.alten.game.controller;

public class LookCommand {
    private final GameController gameController;

    public LookCommand(GameController gameController) {
        this.gameController = gameController;
    }

    public void run() {
        gameController.getCurrentRoom().getInformation();
    }

}