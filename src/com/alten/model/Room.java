package com.alten.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private String name;
    private List<Item> roomItems;
    private List<Animal> roomAnimals;
    private Map<String, Room> adjacentRooms;

    public Room(String name) {
        this.name = name;
        this.roomItems = new ArrayList<>();
        this.roomAnimals = new ArrayList<>();
        this.adjacentRooms = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getRoomItems() {
        return roomItems;
    }

    public void setRoomItems(List<Item> roomItems) {
        this.roomItems = roomItems;
    }

    public List<Animal> getRoomAnimals() {
        return roomAnimals;
    }

    public void setRoomAnimals(List<Animal> roomAnimals) {
        this.roomAnimals = roomAnimals;
    }

    public Map<String, Room> getAdjacentRooms() {
        return adjacentRooms;
    }

    public void setAdjacentRooms(Map<String, Room> adjacentRooms) {
        this.adjacentRooms = adjacentRooms;
    }
}
