package com.alten.model;

import java.time.LocalDate;

public abstract class TailedAnimal extends Animal {

    private float tailLength;

    public TailedAnimal(String name, String favouriteFood, int age, LocalDate arrivalDateAtZoo, float height, float weight, float tailLength) {
        super(name, favouriteFood, age, arrivalDateAtZoo, height, weight);
        this.tailLength = tailLength;
    }

    public float getTailLength() {
        return tailLength;
    }

    public void setTailLength(float tailLength) {
        this.tailLength = tailLength;
    }
}
