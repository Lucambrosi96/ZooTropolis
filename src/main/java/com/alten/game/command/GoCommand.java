package com.alten.game.command;

import com.alten.game.controller.GameController;
import com.alten.game.model.Room;

import java.util.List;

public class GoCommand implements Command {
    private final GameController gameController;

    public GoCommand() {
        this.gameController = GameController.getInstance();
    }

    @Override
    public void execute(List<String> parameters) {
        if (parameters.isEmpty()) {
            System.out.println("Insert a direction");
        } else {
            String direction = parameters.get(0);
            if (gameController.getCurrentRoom().checkDirection(direction)) {
                Room nextRoom = gameController.getCurrentRoom().move(direction);
                gameController.setCurrentRoom(nextRoom);
                gameController.getCurrentRoom().getInformation();
            } else {
                System.out.println("There is no room in that direction");
            }
        }
    }
}