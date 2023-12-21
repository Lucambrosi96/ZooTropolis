package com.alten.game.controller;

import java.util.List;

public class GoCommand implements Command {
    private final GameController gameController;

    public GoCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute(List<String> parameters) {
        parameters.stream()
                .skip(1)
                .findFirst()
                .ifPresent(direction -> {
                    if (gameController.getCurrentRoom().checkDirection(direction)) {
                        gameController.setCurrentRoom(gameController.getCurrentRoom().move(direction));
                        gameController.getCurrentRoom().getInformation();
                    } else {
                        System.out.println("There is no room in that direction");
                    }
                });
    }
}