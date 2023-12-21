package com.alten.game.controller;

import java.util.List;

public class LookCommand implements Command{
    private final GameController gameController;

    public LookCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute(List<String> parameters) {
        gameController.getCurrentRoom().getInformation();
    }
}