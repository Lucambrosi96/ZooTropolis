package com.alten.game.controller;

import com.alten.game.model.Item;

public class GetController extends Controller {
    public GetController(GameController gameController) {
        super(gameController);
    }

    @Override
    public void run() {
    }

    @Override
    public void complexActionRun(String itemName) {
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