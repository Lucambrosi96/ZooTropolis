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

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public int slotsOccupied() {
        return items.stream()
                .mapToInt(Item::getSlotsOccupied)
                .sum();
    }

    public boolean addItem(Item item) {
        if(checkItemEnters(item)){
            items.add(item);
            return true;
        }
        return false;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public boolean checkItemEnters(Item item) {
        int bagUsedSlots = slotsOccupied() + item.getSlotsOccupied();
        return bagUsedSlots <= slots;
    }

    public int freeSlots() {
        return slots - slotsOccupied();
    }

    public Item getItemByName(String itemName) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);
    }
}