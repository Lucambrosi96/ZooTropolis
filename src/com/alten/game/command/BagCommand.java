package com.alten.game.command;

import com.alten.game.controller.GameController;
import com.alten.game.model.Item;
import com.alten.game.model.Player;

import java.util.List;

public class BagCommand implements Command{
    private final GameController gameController;

    public BagCommand() {
        this.gameController = GameController.getInstance();
    }

    @Override
    public void execute(List<String> parameters) {
        Player player = gameController.getPlayer();
        if (player.isBagEmpty()) {
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