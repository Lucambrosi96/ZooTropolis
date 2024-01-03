package com.alten.game.command;

import com.alten.game.controller.GameController;

import java.util.List;

public class LookCommand implements Command{
    private final GameController gameController;

    public LookCommand() {
        this.gameController = GameController.getInstance();
    }

    @Override
    public void execute(List<String> parameters) {
        gameController.getCurrentRoom().getInformation();
    }
}