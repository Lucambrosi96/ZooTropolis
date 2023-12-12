package com.alten.controller;

public class GoController extends Controller {
    public GoController(GameController gameController) {
        super(gameController);
    }

    @Override
    public void run() {
    }

    @Override
    public void complexActionRun(String direction) {
        if (!gameController.getCurrentRoom().getAdjacentRooms().containsKey(direction)) {
            System.out.println("There is no room in that direction");
        } else {
            gameController.setCurrentRoom(gameController.getCurrentRoom().getAdjacentRooms().get(direction));
            new LookController(gameController).run();
        }
    }
}
