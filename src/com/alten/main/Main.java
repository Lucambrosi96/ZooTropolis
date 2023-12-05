package com.alten.main;

import com.alten.model.Player;
import com.alten.model.Room;
import com.alten.util.GameController;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Vincent",10);
        Room room = new Room("Castle");

        GameController gameController = new GameController(player,room);
        gameController.populateGame();
        gameController.runGame();
    }
}