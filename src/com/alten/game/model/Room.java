package com.alten.game.model;

import com.alten.animal.model.Animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private String name;
    private List<Item> items;
    private List<Animal> animals;
    private Map<String, Room> adjacentRooms;

    public Room(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.adjacentRooms = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Map<String, Room> getAdjacentRooms() {
        return adjacentRooms;
    }

    public void setAdjacentRooms(Map<String, Room> adjacentRooms) {
        this.adjacentRooms = adjacentRooms;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void getInformation() {
        System.out.println("You are in " + getName());
        System.out.print("Items: ");
        for (Item item : getItems()) {
            System.out.print(item + " ");
        }
        System.out.print("\nNPC: ");
        for (Animal animal : getAnimals()) {
            System.out.print(animal + " ");
        }
        System.out.println();
    }

    public boolean checkDirection(String direction) {
        return getAdjacentRooms().containsKey(direction);
    }

    public Room move(String direction) {
        return getAdjacentRooms().get(direction);
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