package com.alten.game.controller;

import com.alten.animal.model.Eagle;
import com.alten.animal.model.Lion;
import com.alten.animal.model.Tiger;
import com.alten.game.model.*;

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

    public GameController(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void populateGame() {
        Room castle = new Room("Castle");
        Room forest = new Room("Forest");
        Room cave = new Room("Cave");
        Room village = new Room("Village");

        castle.addAdjacentRooms(NORTH, forest);
        castle.addAdjacentRooms(WEST, village);
        forest.addAdjacentRooms(SOUTH, castle);
        forest.addAdjacentRooms(WEST, cave);
        village.addAdjacentRooms(EAST, castle);
        village.addAdjacentRooms(NORTH, cave);
        cave.addAdjacentRooms(EAST, forest);
        cave.addAdjacentRooms(SOUTH, village);

        Item longSword = new Item("Long Sword", "The berserk sword", 7);
        Item sword = new Item("Sword", "The berserk sword", 5);
        Item shield = new Item("Shield", "Shield of the knights of the round table", 4);
        Item potion = new Item("Potion", "A potion with a strange taste", 2);
        Item diamond = new Item("Diamond", "A shiny diamond", 1);
        Item gold = new Item("Gold", "A small piece of gold", 3);
        Item ring = new Item("Ring", "The elden ring", 2);

        castle.addItem(longSword);
        castle.addItem(sword);
        forest.addItem(shield);
        forest.addItem(potion);
        village.addItem(ring);
        cave.addItem(gold);
        cave.addItem(diamond);

        Lion simba = new Lion("Simba", "Zebra", 2, LocalDate.of(2023, 10, 9), 1.50f, 100f, 0.50f);
        Lion mufasa = new Lion("Mufasa", "Zebra", 2, LocalDate.of(2023, 10, 9), 1.50f, 100f, 0.50f);
        Tiger black = new Tiger("Black", "Antelope", 7, LocalDate.of(2020, 10, 10), 2.00f, 270f, 0.80f);
        Tiger pinco = new Tiger("Pinco", "Antelope", 7, LocalDate.of(2020, 10, 10), 2.00f, 270f, 0.80f);
        Eagle olympia = new Eagle("Olympia", "Rabbit", 3, LocalDate.of(2019, 10, 5), 0.75f, 3f, 1.80f);

        castle.addAnimal(simba);
        forest.addAnimal(olympia);
        forest.addAnimal(mufasa);
        village.addAnimal(black);
        cave.addAnimal(pinco);

        currentRoom = castle;
    }

    public void commands() {
        System.out.println("List of commands: \n-look \n-bag \n-go \n-get \n-drop \n-exit");
    }

    public void setActionMaps() {
        simpleActionMap = new HashMap<>();
        complexActionMap = new HashMap<>();

        LookCommand lookCommand = new LookCommand(this);
        BagCommand bagCommand = new BagCommand(this);
        GoCommand goCommand = new GoCommand(this);
        GetCommand getCommand = new GetCommand(this);
        DropCommand dropCommand = new DropCommand(this);

        simpleActionMap.put("commands", this::commands);
        simpleActionMap.put("look", lookCommand::run);
        simpleActionMap.put("bag", bagCommand::run);
        complexActionMap.put("go", goCommand::run);
        complexActionMap.put("get", getCommand::run);
        complexActionMap.put("drop", dropCommand::run);
    }

    public void checkAnswer(String answer) {
        String[] inputWords = answer.trim().split("\\s+", 2);
        if (!answer.trim().isEmpty()) {
            String commandKey = inputWords[0];

            if (inputWords.length == 1 && simpleActionMap.containsKey(commandKey)) {
                simpleActionMap.get(commandKey).run();
            } else if (inputWords.length == 2 && complexActionMap.containsKey(commandKey)) {
                String commandValue = inputWords[1];
                complexActionMap.get(commandKey).accept(commandValue);
            } else {
                System.out.println("Invalid command. Try again");
            }
        } else {
            System.out.println("Use one of the commands");
            commands();
        }
    }

    public void runGame() {
        setActionMaps();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to ZooTropolis");
        System.out.println("Type 'commands' to see all the commands, 'exit' to end the game");

        boolean endGame = false;

        while (!endGame) {
            System.out.println("What do you want to do?");
            System.out.print("> ");
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