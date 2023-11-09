package com.alten.model;

import java.time.LocalDate;

public abstract class TailedAnimal extends Animal {

    private float tailLenght;

    public TailedAnimal(String name, String favouriteFood, int age, LocalDate arrivalDateAtZoo, float height, float weight, float tailLenght) {
        super(name, favouriteFood, age, arrivalDateAtZoo, height, weight);
        this.tailLenght = tailLenght;
    }

    public float getTailLenght() {
        return tailLenght;
    }

    public void setTailLenght(float tailLenght) {
        this.tailLenght = tailLenght;
    }
}
