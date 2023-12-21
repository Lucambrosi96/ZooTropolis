package com.alten.game.controller;

import com.alten.game.model.Item;
import com.alten.game.model.Player;

import java.util.List;

public class BagCommand implements Command{
    private final GameController gameController;

    public BagCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute(List<String> parameters) {
        Player player = gameController.getPlayer();
        if (player.bagIsEmpty()) {
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