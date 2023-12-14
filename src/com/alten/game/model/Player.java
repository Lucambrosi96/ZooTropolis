package com.alten.game.model;

import java.util.List;

public class Player {
    private String name;
    private int lifePoints;
    private Bag bag;

    public Player(String name, int lifePoints) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.bag = new Bag();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public void addItemToBag(Item item) {
        bag.addItem(item);
    }

    public void removeItemFromBag(Item item) {
        bag.removeItem(item);
    }

    public List<Item> getItemsFromBag() {
        return bag.getItems();
    }

    public boolean checkItemEntersInBag(Item item) {
        return bag.checkItemEnters(item);
    }

    public int freeSlotsInBag() {
        return bag.freeSlots();
    }

    public Item getItemByName(String itemName) {
        return bag.getItemByName(itemName);
    }
}