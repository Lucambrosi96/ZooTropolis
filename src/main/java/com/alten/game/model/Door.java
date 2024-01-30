package com.alten.game.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Door {
    private boolean isOpen;

    private String requiredKey;

    @Setter
    private Room startingRoom;
    @Setter
    private Room arrivalRoom;

    public Door(boolean isOpen, String requiredKey) {
        this.isOpen = isOpen;
        this.requiredKey = requiredKey;
    }

    public Door(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public boolean unlock(String itemName) {
        isOpen = !isOpen && itemName.equalsIgnoreCase(requiredKey);
        return isOpen;
    }

    public Room getDestinationRoom(Room currentRoom) {
        return (currentRoom == startingRoom) ? arrivalRoom : startingRoom;
    }
}
