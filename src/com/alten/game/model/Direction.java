package com.alten.game.model;

import java.util.stream.Stream;

public enum Direction {

    NORTH("north"),
    SOUTH("south"),
    EAST("east"),
    WEST("west");

    private final String name;

    Direction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Direction getDirectionFromName(String directionName){
        return Stream.of(Direction.values())
                .filter(direction -> direction.getName().equalsIgnoreCase(directionName))
                .findFirst()
                .orElse(null);
    }
}
