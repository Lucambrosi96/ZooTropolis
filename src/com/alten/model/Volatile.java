package com.alten.model;

public abstract class Volatile extends Animale{

    public float aperturaAlare;

    public Volatile(String nome, String ciboPreferito, int eta, String dataArrivoAlloZoo, float altezza, float peso, float aperturaAlare) {
        super(nome, ciboPreferito, eta, dataArrivoAlloZoo, altezza, peso);
        this.aperturaAlare=aperturaAlare;
    }

    public float getAperturaAlare() {
        return aperturaAlare;
    }

    public void setAperturaAlare(float aperturaAlare) {
        this.aperturaAlare = aperturaAlare;
    }
}

