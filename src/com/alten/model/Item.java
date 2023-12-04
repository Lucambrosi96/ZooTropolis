package com.alten.model;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSlotsOccupied() {
        return slotsOccupied;
    }

    public void setSlotsOccupied(int slotsOccupied) {
        this.slotsOccupied = slotsOccupied;
    }

    @Override
    public String toString() {
        return name + ", slot occupati: " + slotsOccupied;
    }
}
