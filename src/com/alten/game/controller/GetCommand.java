package com.alten.game.controller;

import com.alten.game.model.Item;

public class GetCommand {
    private final GameController gameController;

    public GetCommand(GameController gameController) {
        this.gameController = gameController;
    }

    public void run(String itemName) {
        Item chosenItem = gameController.getCurrentRoom().getItemByName(itemName);
        if (chosenItem == null) {
            System.out.println("Item not found in the room");
        } else {
            if (gameController.getPlayer().checkItemEntersInBag(chosenItem)) {
                gameController.getCurrentRoom().removeItem(chosenItem);
                gameController.getPlayer().addItemToBag(chosenItem);
                System.out.println("Got item: " + chosenItem.getName());
            } else {
                System.out.println("Your bag is full.");
            }
        }
    }
}