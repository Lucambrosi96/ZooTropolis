package com.alten.controller;

import com.alten.model.Item;

public class DropController extends Controller {

    public DropController(GameController gameController) {
        super(gameController);
    }

    @Override
    public void run() {
    }

    @Override
    public void complexActionRun(String itemName) {
        Item droppedItem = null;
        for (Item item : gameController.getPlayer().getBag().getItemList()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                droppedItem = item;
            }
        }
        if (droppedItem == null) {
            System.out.println("Item not found in your bag");
        } else {
            gameController.getPlayer().getBag().getItemList().remove(droppedItem);
            gameController.getCurrentRoom().getRoomItems().add(droppedItem);
            System.out.println("Dropped item: " + droppedItem.getName());
        }
    }
}
