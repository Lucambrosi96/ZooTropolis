package com.alten.game.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
@Getter
public enum Direction {

    NORTH("north"),
    SOUTH("south"),
    EAST("east"),
    WEST("west");

    private final String name;

    public static Direction getDirectionFromName(String directionName) {
        return Stream.of(Direction.values())
                .filter(direction -> direction.getName().equalsIgnoreCase(directionName))
                .findFirst()
                .orElse(null);
    }

    public static Direction getOppositeDirection(Direction direction){
        return switch (direction){
            case NORTH -> SOUTH;
            case EAST -> WEST;
            case WEST -> EAST;
            case SOUTH -> NORTH;
        };
    }
}
