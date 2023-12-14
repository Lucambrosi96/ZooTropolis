package com.alten.game.controller;

import com.alten.game.model.Item;

public class DropCommand {
    private final GameController gameController;

    public DropCommand(GameController gameController) {
        this.gameController = gameController;
    }

    public void run(String itemName) {
        Item droppedItem = gameController.getPlayer().getItemByName(itemName);
        if (droppedItem == null) {
            System.out.println("Item not found in your bag");
        } else {
            gameController.getPlayer().removeItemFromBag(droppedItem);
            gameController.getCurrentRoom().addItem(droppedItem);
            System.out.println("Dropped item: " + droppedItem.getName());
        }
    }
}