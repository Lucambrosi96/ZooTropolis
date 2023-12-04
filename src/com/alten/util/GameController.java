package com.alten.util;

import com.alten.model.*;

import java.time.LocalDate;
import java.util.Scanner;

public class GameController {
    private Player player;
    private Room currentRoom;

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

        castle.getAdjacentRooms().put("North", forest);
        castle.getAdjacentRooms().put("West", village);
        forest.getAdjacentRooms().put("South", castle);
        forest.getAdjacentRooms().put("West", cave);
        village.getAdjacentRooms().put("East", castle);
        village.getAdjacentRooms().put("North", cave);
        cave.getAdjacentRooms().put("East", forest);
        cave.getAdjacentRooms().put("South", village);

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
}
