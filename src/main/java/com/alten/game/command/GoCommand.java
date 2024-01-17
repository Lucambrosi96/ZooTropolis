package com.alten.game.command;

import com.alten.game.controller.GameController;
import com.alten.game.model.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GoCommand implements Command{

    private final GameController gameController;

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