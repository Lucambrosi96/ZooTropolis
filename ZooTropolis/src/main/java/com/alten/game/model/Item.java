package com.alten.game.model;

import lombok.Getter;

@Getter
public class Item {
    private String name;
    private String description;
    private int slotsOccupied;

    public Item(String name, String description, int slotsOccupied) {
        this.name = name;
        this.description = description;
        this.slotsOccupied = slotsOccupied;
    }

    @Override
    public String toString() {
        return name + ", occupied slots: " + slotsOccupied + ". ";
    }
}
