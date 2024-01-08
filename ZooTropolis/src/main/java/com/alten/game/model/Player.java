package com.alten.game.model;

import lombok.Getter;

import java.util.List;

public class Player {
    @Getter
    private String name;
    private int lifePoints;
    private final Bag bag;

    public Player(String name, int lifePoints) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.bag = new Bag();
    }

    public boolean addItemToBag(Item item) {
        return bag.addItem(item);
    }

    public void removeItemFromBag(Item item) {
        bag.removeItem(item);
    }

    public List<Item> getItemsFromBag() {
        return bag.getItems();
    }

    public boolean isBagEmpty(){
        return bag.isEmpty();
    }

    public int freeSlotsInBag() {
        return bag.freeSlots();
    }

    public Item getItemByName(String itemName) {
        return bag.getItemByName(itemName);
    }
}