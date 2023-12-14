package com.alten.game.controller;

import com.alten.game.model.Item;
import com.alten.game.model.Player;

public class BagCommand {
    private final GameController gameController;

    public BagCommand(GameController gameController) {
        this.gameController = gameController;
    }

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
}