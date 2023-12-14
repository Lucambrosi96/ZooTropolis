package com.alten.game.model;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private final List<Item> items;
    private final int slots;

    public Bag() {
        this.items = new ArrayList<>();
        this.slots = 10;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getSlots() {
        return slots;
    }

    public int slotsOccupied() {
        int slotsOccupied = 0;
        for (Item item : items) {
            slotsOccupied = slotsOccupied + item.getSlotsOccupied();
        }
        return slotsOccupied;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public boolean checkItemEnters(Item item) {
        int bagUsedSlots = slotsOccupied() + item.getSlotsOccupied();
        return bagUsedSlots <= getSlots();
    }

    public int freeSlots() {
        return getSlots() - slotsOccupied();
    }

    public Item getItemByName(String itemName) {
        Item chosenItem = null;
        for (Item item : getItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                chosenItem = item;
            }
        }
        return chosenItem;
    }
}