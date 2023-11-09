package com.alten.model;

import java.time.LocalDate;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getArrivalDateAtZoo() {
        return arrivalDateAtZoo;
    }

    public void setArrivalDateAtZoo(LocalDate arrivalDateAtZoo) {
        this.arrivalDateAtZoo = arrivalDateAtZoo;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
