package com.alten.game.command;

import com.alten.game.controller.GameController;
import com.alten.game.model.Item;

import java.util.List;

public class GetCommand implements Command {
    private final GameController gameController;

    public GetCommand() {
        this.gameController = GameController.getInstance();
    }

    @Override
    public void execute(List<String> parameters) {
        if (parameters.isEmpty()) {
            System.out.println("Insert an item");
        } else {
            String itemName = parameters.get(0);
            Item chosenItem = gameController.getCurrentRoom().getItemByName(itemName);
            if (chosenItem == null) {
                System.out.println("Item not found in the room");
            } else {
                if (gameController.getPlayer().addItemToBag(chosenItem)) {
                    gameController.getCurrentRoom().removeItem(chosenItem);
                    System.out.println("Got item: " + chosenItem.getName());
                } else {
                    System.out.println("Your bag is full.");
                }
            }
        }
    }
}