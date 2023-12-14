package com.alten.game.model;

public class Item {
    private String name;
    private String description;
    private int slotsOccupied;

    public Item(String name, String description, int slotsOccupied) {
        this.name = name;
        this.description = description;
        this.slotsOccupied = slotsOccupied;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getSlotsOccupied() {
        return slotsOccupied;
    }

    @Override
    public String toString() {
        return name + ", occupied slots: " + slotsOccupied + ". ";
    }
}
