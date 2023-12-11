package com.alten.util;

import com.alten.model.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class GameController {
    private final Player player;
    private Room currentRoom;
    private static final String NORTH = "north";
    private static final String SOUTH = "south";
    private static final String WEST = "west";
    private static final String EAST = "east";
    private Map<String, Runnable> simpleActionMap;
    private Map<String, Consumer<String>> complexActionMap;

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
        System.out.print("Items: ");
        for (Item item : currentRoom.getRoomItems()) {
            System.out.print(item + " ");
        }
        System.out.print("\nNPC: ");
        for (Animal animal : currentRoom.getRoomAnimals()) {
            System.out.print(animal + " ");
        }
        System.out.println();
    }

    public void bag() {
        if (player.getBag().getItemList().isEmpty()) {
            System.out.println("The bag is empty");
        } else {
            System.out.print("In bag: ");
            for (Item item : player.getBag().getItemList()) {
                System.out.print(item + " ");
            }
            System.out.println("Free slots: " + (player.getBag().getSlots() - player.getBag().slotsOccupied()));
        }
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
            int bagUsedSlots = bag.slotsOccupied() + chosenItem.getSlotsOccupied();

            if (bagUsedSlots > bag.getSlots()) {
                System.out.println("Your bag is full.");
            } else {
                currentRoom.getRoomItems().remove(chosenItem);
                bag.getItemList().add(chosenItem);
                System.out.println("Got item: " + chosenItem.getName());
            }
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

    public void setActionMaps() {
        simpleActionMap = new HashMap<>();
        complexActionMap = new HashMap<>();

        simpleActionMap.put("look", this::look);
        simpleActionMap.put("bag", this::bag);
        complexActionMap.put("go", this::go);
        complexActionMap.put("get", this::get);
        complexActionMap.put("drop", this::drop);
    }

    public void checkAnswer(String answer) {
        String[] inputWords = answer.split(" ");
        String commandKey = inputWords[0];

        if (inputWords.length == 1 && simpleActionMap.containsKey(commandKey)) {
            simpleActionMap.get(commandKey).run();
        } else if (inputWords.length == 2 && complexActionMap.containsKey(commandKey)) {
            String commandValue = inputWords[1];
            complexActionMap.get(commandKey).accept(commandValue);
        } else {
            System.out.println("Invalid command. Try again");
        }
    }

    public void runGame() {
        setActionMaps();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to ZooTropolis");
        System.out.println("Type 'exit' to end the game");

        boolean endGame = false;

        while (!endGame) {
            System.out.println("What do you want to do?");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("exit")) {
                endGame = true;
                System.out.println("Thanks for playing");
            } else {
                checkAnswer(answer.toLowerCase());
            }
        }
    }
}