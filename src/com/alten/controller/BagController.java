package com.alten.controller;

import com.alten.model.Bag;
import com.alten.model.Item;

public class BagController extends Controller {
    public BagController(GameController gameController) {
        super(gameController);
    }

    @Override
    public void run() {
        Bag bag = gameController.getPlayer().getBag();
        if (bag.getItemList().isEmpty()) {
            System.out.println("The bag is empty");
        } else {
            System.out.print("In bag: ");
            for (Item item : bag.getItemList()) {
                System.out.print(item + " ");
            }
            System.out.println("Free slots: " + (bag.getSlots() - bag.slotsOccupied()));
        }
    }

    @Override
    public void complexActionRun(String args) {
    }
}
