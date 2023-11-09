package com.alten.model;

import java.time.LocalDate;

public abstract class WingedAnimal extends Animal {

    private float wingspan;

    public WingedAnimal(String name, String favouriteFood, int age, LocalDate arrivalDateAtZoo, float height, float weight, float wingspan) {
        super(name, favouriteFood, age, arrivalDateAtZoo, height, weight);
        this.wingspan = wingspan;
    }

    public float getWingspan() {
        return wingspan;
    }

    public void setWingspan(float wingspan) {
        this.wingspan = wingspan;
    }
}



