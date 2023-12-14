package com.alten.game.controller;

import com.alten.game.model.Item;
import com.alten.game.model.Player;

public class BagController extends Controller {
    public BagController(GameController gameController) {
        super(gameController);
    }

    @Override
    public void run() {
        Player player = gameController.getPlayer();
        if (player.getItemsFromBag().isEmpty()) {
            System.out.println("The bag is empty");
        } else {
            System.out.print("In bag: ");
            for (Item item : player.getItemsFromBag()) {
                System.out.print(item + " ");
            }
            System.out.println("Free slots: " + player.freeSlotsInBag());
        }
    }

    @Override
    public void complexActionRun(String args) {
    }
}