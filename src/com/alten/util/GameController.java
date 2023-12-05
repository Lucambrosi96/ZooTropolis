package com.alten.util;

import com.alten.model.*;

import java.time.LocalDate;
import java.util.Scanner;

public class GameController {
    private final Player player;
    private Room currentRoom;
    private static final String NORTH = "North";
    private static final String SOUTH = "South";
    private static final String WEST = "West";
    private static final String EAST = "East";

    public GameController(Player player, Room currentRoom) {
        this.player = player;
        this.currentRoom = currentRoom;
    }

    public void populateGame() {
        Bag bag = new Bag();
        player.setBag(bag);

        Room castle = new Room("Castle");
        Room forest = new Room("Forest");
        Room cave = new Room("Cave");
        Room village = new Room("Village");

        castle.getAdjacentRooms().put(NORTH, forest);
        castle.getAdjacentRooms().put(WEST, village);
        forest.getAdjacentRooms().put(SOUTH, castle);
        forest.getAdjacentRooms().put(WEST, cave);
        village.getAdjacentRooms().put(EAST, castle);
        village.getAdjacentRooms().put(NORTH, cave);
        cave.getAdjacentRooms().put(EAST, forest);
        cave.getAdjacentRooms().put(SOUTH, village);

        Item sword = new Item("Sword", "The berserk sword", 5);
        Item shield = new Item("Shield", "Shield of the knights of the round table", 4);
        Item potion = new Item("Potion", "A potion with a strange taste", 2);
        Item diamond = new Item("Diamond", "A shiny diamond", 1);
        Item gold = new Item("Gold", "A small piece of gold", 3);
        Item ring = new Item("Ring", "The elden ring", 2);

        castle.getRoomItems().add(sword);
        forest.getRoomItems().add(shield);
        forest.getRoomItems().add(potion);
        village.getRoomItems().add(ring);
        cave.getRoomItems().add(gold);
        cave.getRoomItems().add(diamond);

        Lion simba = new Lion("Simba", "Zebra", 2, LocalDate.of(2023, 10, 9), 1.50f, 100f, 0.50f);
        Lion mufasa = new Lion("Mufasa", "Zebra", 2, LocalDate.of(2023, 10, 9), 1.50f, 100f, 0.50f);
        Tiger black = new Tiger("Black", "Antelope", 7, LocalDate.of(2020, 10, 10), 2.00f, 270f, 0.80f);
        Tiger pinco = new Tiger("Pinco", "Antelope", 7, LocalDate.of(2020, 10, 10), 2.00f, 270f, 0.80f);
        Eagle olympia = new Eagle("Olympia", "Rabbit", 3, LocalDate.of(2019, 10, 5), 0.75f, 3f, 1.80f);

        castle.getRoomAnimals().add(simba);
        forest.getRoomAnimals().add(olympia);
        forest.getRoomAnimals().add(mufasa);
        village.getRoomAnimals().add(black);
        cave.getRoomAnimals().add(pinco);

        currentRoom = castle;
    }

    public void go(String direction) {
        if (!currentRoom.getAdjacentRooms().containsKey(direction)) {
            System.out.println("There is no room in that direction");
        } else {
            currentRoom = currentRoom.getAdjacentRooms().get(direction);
            look();
        }
    }

    public void look() {
        System.out.println("You are in " + currentRoom.getName());
        System.out.println("Items: " + currentRoom.getRoomItems());
        System.out.println("NPC:" + currentRoom.getRoomAnimals());
    }

    public void bag() {
        if (player.getBag().getItemList().isEmpty()) {
            System.out.println("The bag is empty");
        } else {
            System.out.println("In bag: " + player.getBag().getItemList());
        }
    }

    public String checkAnswer(String answer) {

        if (answer.startsWith("get ")) {
            String itemName = answer.substring(4).trim();
            answer = answer.substring(0, 3);
            get(itemName);
        }
        if (answer.startsWith("drop ")) {
            String itemName = answer.substring(5).trim();
            answer = answer.substring(0, 4);
            drop(itemName);
        }
        return answer;
    }

    public void get(String itemName) {
        Bag bag = player.getBag();
        Item chosenItem = null;
        for (Item item : currentRoom.getRoomItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                chosenItem = item;
            }
        }
        if (chosenItem == null) {
            System.out.println("Item not found in the room");
        } else {
            int bagSlotsOccupied = bag.slotsOccupied();

            int bagUsedSlots = bagSlotsOccupied + chosenItem.getSlotsOccupied();

            if (bagUsedSlots > bag.getSlots()) {
                System.out.println("Your bag is full.");
            }
            currentRoom.getRoomItems().remove(chosenItem);
            bag.getItemList().add(chosenItem);
            System.out.println("Got item: " + chosenItem.getName());
        }


    }

    public void drop(String itemName) {
        Item droppedItem = null;
        for (Item item : player.getBag().getItemList()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                droppedItem = item;
            }
        }
        if (droppedItem == null) {
            System.out.println("Item not found in your bag");
        } else {
            player.getBag().getItemList().remove(droppedItem);
            currentRoom.getRoomItems().add(droppedItem);
            System.out.println("Dropped item: " + droppedItem.getName());
        }

    }

    public void runGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to ZooTropolis");
        System.out.println("Type 'exit' to end the game");

        boolean endGame = false;

        while (!endGame) {
            System.out.println("What do you want to do?");
            String answer = scanner.nextLine();
            answer = checkAnswer(answer);

            switch (answer.toLowerCase()) {
                case "go north":
                    go(NORTH);
                    break;
                case "go south":
                    go(SOUTH);
                    break;
                case "go west":
                    go(WEST);
                    break;
                case "go east":
                    go(EAST);
                    break;
                case "look":
                    look();
                    break;
                case "bag":
                    bag();
                    break;
                case "get":
                    break;
                case "drop":
                    break;
                case "exit":
                    System.out.println("Thanks for playing");
                    endGame = true;
                    break;
                default:
                    System.out.println("Invalid command. Try again");
                    break;
            }
        }
    }
}
