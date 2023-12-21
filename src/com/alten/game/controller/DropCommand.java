package com.alten.game.controller;

import com.alten.game.model.Item;

import java.util.List;

public class DropCommand implements Command {
    private final GameController gameController;

    public DropCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute(List<String> parameters) {
        parameters.stream()
                .skip(1)
                .findFirst()
                .ifPresent(itemName -> {
                    Item droppedItem = gameController.getPlayer().getItemByName(itemName);
                    if (droppedItem == null) {
                        System.out.println("Item not found in your bag");
                    } else {
                        gameController.getPlayer().removeItemFromBag(droppedItem);
                        gameController.getCurrentRoom().addItem(droppedItem);
                        System.out.println("Dropped item: " + droppedItem.getName());
                    }
                });
    }
}