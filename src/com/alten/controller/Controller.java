package com.alten.controller;

public abstract class Controller {

    protected GameController gameController;

    protected Controller(GameController gameController) {
        this.gameController = gameController;
    }

    public abstract void run();

    public abstract void complexActionRun(String args);
}
