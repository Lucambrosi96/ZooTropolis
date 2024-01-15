package com.alten.game.command;

import com.alten.game.controller.GameController;
import com.alten.game.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoCommand implements Command{

    private final GameController gameController;

    @Autowired
    public GoCommand(GameController gameController) {
        this.gameController = gameController;
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