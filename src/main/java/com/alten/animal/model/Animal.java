package com.alten.animal.model;

import lombok.*;

import java.time.LocalDate;
@Data
public abstract class Animal {

    private String name;
    private String favouriteFood;
    private int age;
    private LocalDate arrivalDateAtZoo;
    private float height;
    private float weight;

    public Animal(String name, String favouriteFood, int age, LocalDate arrivalDateAtZoo, float height, float weight) {
        this.name = name;
        this.favouriteFood = favouriteFood;
        this.age = age;
        this.arrivalDateAtZoo = arrivalDateAtZoo;
        this.height = height;
        this.weight = weight;
    }

}
