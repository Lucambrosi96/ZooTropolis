package com.alten.game.model;

import com.alten.animal.model.Animal;
import lombok.Getter;

import java.util.*;

public class Room {
    @Getter
    private final String name;
    private final List<Item> items;
    private final List<Animal> animals;

    @Getter
    private final Map<Direction, Door> adjacentDoors;

    public Room(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.adjacentDoors = new EnumMap<>(Direction.class);
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

    public void addAdjacentDoors(Direction direction, Room nextRoom, Door door) {
        adjacentDoors.put(direction, door);
        door.setStartingRoom(this);
        door.setArrivalRoom(nextRoom);
        nextRoom.adjacentDoors.put(Direction.getOppositeDirection(direction), door);
    }

    public void getInformation() {
        System.out.println("You are in " + getName());
        System.out.println("Available directions:");
        this.getAvailableDoors();
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
        return getAdjacentDoors().containsKey(direction);
    }

    public Item getItemByName(String itemName) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);
    }

    public Door getDoor(Direction direction) {
        return adjacentDoors.get(direction);
    }

    public Room getDestination(Direction direction) {
        return getDoor(direction).getDestinationRoom(this);
    }

    public void switchRoom(Direction direction) {
        adjacentDoors.get(direction).switchRoom();
    }

    public void getAvailableDoors() {
        adjacentDoors.forEach((direction, door) -> {
            String doorStatus = door.isOpen() ? "open" : "closed";
            System.out.println(direction + " door: " + doorStatus);
        });
    }
}