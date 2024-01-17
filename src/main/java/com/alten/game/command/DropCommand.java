package com.alten.game.command;

import com.alten.game.controller.GameController;
import com.alten.game.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class DropCommand implements Command {

    private final GameController gameController;

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