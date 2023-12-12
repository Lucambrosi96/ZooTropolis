package com.alten.controller;

import com.alten.model.Bag;
import com.alten.model.Item;

public class GetController extends Controller {
    public GetController(GameController gameController) {
        super(gameController);
    }

    @Override
    public void run() {
    }

    @Override
    public void complexActionRun(String itemName) {
        Bag bag = gameController.getPlayer().getBag();
        Item chosenItem = null;
        for (Item item : gameController.getCurrentRoom().getRoomItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                chosenItem = item;
            }
        }
        if (chosenItem == null) {
            System.out.println("Item not found in the room");
        } else {
            int bagUsedSlots = bag.slotsOccupied() + chosenItem.getSlotsOccupied();

            if (bagUsedSlots > bag.getSlots()) {
                System.out.println("Your bag is full.");
            } else {
                gameController.getCurrentRoom().getRoomItems().remove(chosenItem);
                bag.getItemList().add(chosenItem);
                System.out.println("Got item: " + chosenItem.getName());
            }
        }
    }
}
