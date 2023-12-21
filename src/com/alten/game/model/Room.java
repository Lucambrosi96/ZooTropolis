package com.alten.game.model;

import com.alten.animal.model.Animal;

import java.util.*;

public class Room {
    private final String name;
    private final List<Item> items;
    private final List<Animal> animals;
    private final Map<Direction, Room> adjacentRooms;

    public Room(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.adjacentRooms = new EnumMap<>(Direction.class);
    }

    public String getName() {
        return name;
    }

    public Map<Direction, Room> getAdjacentRooms() {
        return adjacentRooms;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void addAdjacentRooms(Direction direction, Room room){
        adjacentRooms.put(direction, room);
    }

    public void getInformation() {
        System.out.println("You are in " + getName());
        System.out.print("Items: ");
        for (Item item : items) {
            System.out.print(item + " ");
        }
        System.out.print("\nNPC: ");
        for (Animal animal : animals) {
            System.out.print(animal + " ");
        }
        System.out.println();
    }

    public boolean checkDirection(String directionName) {
        Direction direction = Direction.getDirectionFromName(directionName);
        return getAdjacentRooms().containsKey(direction);
    }

    public Room move(String directionName) {
        Direction direction = Direction.getDirectionFromName(directionName);
        return getAdjacentRooms().get(direction);
    }

    public Item getItemByName(String itemName) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);
    }
}