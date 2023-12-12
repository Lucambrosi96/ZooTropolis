package com.alten.controller;

import com.alten.model.Animal;
import com.alten.model.Item;

public class LookController extends Controller {
    public LookController(GameController gameController) {
        super(gameController);
    }

    @Override
    public void run() {
        System.out.println("You are in " + gameController.getCurrentRoom().getName());
        System.out.print("Items: ");
        for (Item item : gameController.getCurrentRoom().getRoomItems()) {
            System.out.print(item + " ");
        }
        System.out.print("\nNPC: ");
        for (Animal animal : gameController.getCurrentRoom().getRoomAnimals()) {
            System.out.print(animal + " ");
        }
        System.out.println();
    }

    @Override
    public void complexActionRun(String args) {
    }
}