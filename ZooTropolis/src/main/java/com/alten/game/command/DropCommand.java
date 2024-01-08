package com.alten.game.command;

import com.alten.game.controller.GameController;
import com.alten.game.model.Item;

import java.util.List;

public class DropCommand implements Command {
    private final GameController gameController;

    public DropCommand() {
        this.gameController = GameController.getInstance();
    }

    @Override
    public void execute(List<String> parameters) {
        if (parameters.isEmpty()) {
            System.out.println("Insert an item");
        } else {
            String itemName = parameters.get(0);
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
}