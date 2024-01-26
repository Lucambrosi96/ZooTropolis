package com.alten.game.controller;

import com.alten.animal.model.Eagle;
import com.alten.animal.model.Lion;
import com.alten.animal.model.Tiger;
import com.alten.game.model.Direction;
import com.alten.game.model.Item;
import com.alten.game.model.Player;
import com.alten.game.model.Room;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@RequiredArgsConstructor
@Component
public class GameController {

    private final ResponseController responseController;
    @Setter
    private boolean endGame = false;
    @Getter
    private final Player player;
    @Getter
    @Setter
    private Room currentRoom;

    public void runGame() {

        responseController.setCommandMap();
        System.out.print("Welcome to ZooTropolis, what's your name?\n> ");
        String playerName = InputController.readString();
        player.setName(playerName);
        player.setLifePoints(10);
        System.out.println("Hello " + player.getName());
        System.out.println("Press ENTER to see all the commands, type 'exit' to end the game");

        while (!endGame) {
            System.out.println("What do you want to do?");
            System.out.print("> ");
            String answer = InputController.readString();
            responseController.manageResponse(answer.toLowerCase());
        }
    }

    public void populateGame() {
        Room castle = new Room("Castle");
        Room forest = new Room("Forest");
        Room cave = new Room("Cave");
        Room village = new Room("Village");

        castle.addAdjacentRooms(Direction.NORTH, forest);
        forest.addAdjacentRooms(Direction.WEST, cave);
        village.addAdjacentRooms(Direction.EAST, castle);
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
}