package com.alten.game.controller;

import com.alten.game.model.Item;

import java.util.List;

public class GetCommand implements Command {
    private final GameController gameController;

    public GetCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute(List<String> parameters) {
        parameters.stream()
                .skip(1)
                .findFirst()
                .ifPresent(itemName -> {
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
                });
    }
}