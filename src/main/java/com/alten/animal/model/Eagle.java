package com.alten.animal.model;

import java.time.LocalDate;

public class Eagle extends WingedAnimal {
    public Eagle(String name, String favouriteFood, int age, LocalDate arrivalDateAtZoo, float height, float weight, float wingspan) {
        super(name, favouriteFood, age, arrivalDateAtZoo, height, weight, wingspan);
    }

    @Override
    public String toString() {
        return getName() + "(" + Eagle.class.getSimpleName() + ")";
    }
}



