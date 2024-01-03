package com.alten.game.command;

import com.alten.game.controller.GameController;

import java.util.List;

public class GoCommand implements Command {
    private final GameController gameController;

    public GoCommand() {
        this.gameController = GameController.getInstance();
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