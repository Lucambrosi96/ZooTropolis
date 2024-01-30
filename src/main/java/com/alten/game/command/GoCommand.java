package com.alten.game.command;


import com.alten.game.controller.GameController;
import com.alten.game.model.Direction;
import com.alten.game.model.Door;
import com.alten.game.model.Item;
import com.alten.game.model.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
@Component
public class GoCommand implements Command {

    private final GameController gameController;

    @Override
    public void execute(List<String> parameters) {
        if (parameters.isEmpty()) {
            System.out.println("Insert a direction");
        } else {
            String directionName = parameters.get(0);
            if (gameController.getCurrentRoom().checkDirection(directionName)) {
                Direction direction = Direction.getDirectionFromName(directionName);
                openDoor(direction);
            } else {
                System.out.println("There is no door in that direction");
            }
        }
    }


    public void openDoor(Direction direction) {
        Door door = gameController.getCurrentRoom().getDoor(direction);
        Scanner scanner = new Scanner(System.in);
        if (!door.isOpen()) {
            System.out.println("The door is locked. Would you like to use an item to unlock it? Y/N");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                unlockDoor(direction);
            } else if (answer.equalsIgnoreCase("N")) {
            } else {
                System.out.println("You must answer Y or N");
            }
        } else {
            changeRoom(direction);
        }
    }

    public void unlockDoor(Direction direction) {
        Door door = gameController.getCurrentRoom().getDoor(direction);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the name of the chosen item");
        String itemName = scanner.nextLine();
        if (gameController.getPlayer().isPresentInBag(itemName) && door.unlock(itemName)) {
            System.out.println("You unlocked the door!");
            Item removedItem = gameController.getPlayer().getItemByName(itemName);
            gameController.getPlayer().removeItemFromBag(removedItem);
            changeRoom(direction);
        } else {
            System.out.println("You need " + door.getRequiredKey() + " to open the door");
        }
    }

    private void changeRoom(Direction direction) {
        Room currentRoom = gameController.getCurrentRoom();
        Room nextRoom = currentRoom.getDestination(direction);
        gameController.setCurrentRoom(nextRoom);
        gameController.getCurrentRoom().getInformation();
    }
}