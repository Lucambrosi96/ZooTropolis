package com.alten.game.controller;

public class LookController extends Controller {
    public LookController(GameController gameController) {
        super(gameController);
    }

    @Override
    public void run() {
        gameController.getCurrentRoom().getInformation();
    }

    @Override
    public void complexActionRun(String args) {
    }
}