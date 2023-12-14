package com.alten.game.controller;

public class GoController extends Controller {
    public GoController(GameController gameController) {
        super(gameController);
    }

    @Override
    public void run() {
    }

    @Override
    public void complexActionRun(String direction) {
        if (gameController.getCurrentRoom().checkDirection(direction)) {
            gameController.setCurrentRoom(gameController.getCurrentRoom().move(direction));
            gameController.getCurrentRoom().getInformation();
        } else {
            System.out.println("There is no room in that direction");
        }
    }
}