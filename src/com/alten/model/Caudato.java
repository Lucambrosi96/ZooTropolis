package com.alten.model;

public abstract class Caudato extends Animale{

    public float lunghezzaCoda;

    public Caudato(String nome, String ciboPreferito, int eta, String dataArrivoAlloZoo, float altezza, float peso, float lunghezzaCoda) {
        super(nome, ciboPreferito, eta, dataArrivoAlloZoo, altezza, peso);
        this.lunghezzaCoda=lunghezzaCoda;
    }

    public float getLunghezzaCoda() {
        return lunghezzaCoda;
    }

    public void setLunghezzaCoda(float lunghezzaCoda) {
        this.lunghezzaCoda = lunghezzaCoda;
    }
}
