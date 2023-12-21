package com.alten.game.controller;

import com.alten.animal.model.Eagle;
import com.alten.animal.model.Lion;
import com.alten.animal.model.Tiger;
import com.alten.game.model.Direction;
import com.alten.game.model.Item;
import com.alten.game.model.Player;
import com.alten.game.model.Room;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GameController {
    private final Player player;
    private Room currentRoom;
    private Map<String, Command> commandMap;

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

        castle.addAdjacentRooms(Direction.NORTH, forest);
        castle.addAdjacentRooms(Direction.WEST, village);
        forest.addAdjacentRooms(Direction.SOUTH, castle);
        forest.addAdjacentRooms(Direction.WEST, cave);
        village.addAdjacentRooms(Direction.EAST, castle);
        village.addAdjacentRooms(Direction.NORTH, cave);
        cave.addAdjacentRooms(Direction.EAST, forest);
        cave.addAdjacentRooms(Direction.SOUTH, village);

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
        commandMap = new HashMap<>();

        LookCommand lookCommand = new LookCommand(this);
        BagCommand bagCommand = new BagCommand(this);
        GoCommand goCommand = new GoCommand(this);
        GetCommand getCommand = new GetCommand(this);
        DropCommand dropCommand = new DropCommand(this);

        commandMap.put("look", lookCommand);
        commandMap.put("bag", bagCommand);
        commandMap.put("go", goCommand);
        commandMap.put("get", getCommand);
        commandMap.put("drop", dropCommand);
    }

    public void checkAnswer(String answer) {
        List<String> inputWords = List.of(answer.trim().split("\\s+", 2));
        if (!answer.trim().isEmpty()) {
            String commandKey = inputWords.get(0);

            if (commandMap.containsKey(commandKey)) {
                commandMap.get(commandKey).execute(inputWords);
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
        System.out.println("Welcome to ZooTropolis " + player.getName());
        System.out.println("Press ENTER to see all the commands, type 'exit' to end the game");

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