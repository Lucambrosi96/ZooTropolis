package com.alten.game.controller;

import com.alten.game.model.Item;

public class DropController extends Controller {

    public DropController(GameController gameController) {
        super(gameController);
    }

    @Override
    public void run() {
    }

    @Override
    public void complexActionRun(String itemName) {
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