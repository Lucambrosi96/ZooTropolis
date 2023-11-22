package com.alten.model;

import java.time.LocalDate;

public class Lion extends TailedAnimal {

    public Lion(String name, String favouriteFood, int age, LocalDate arrivalDateAtZoo, float height, float weight, float tailLength) {
        super(name, favouriteFood, age, arrivalDateAtZoo, height, weight, tailLength);
    }
}
