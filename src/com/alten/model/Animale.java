package com.alten.model;

public abstract class Animale {

    public String nome;
    public String ciboPreferito;
    public int eta;
    public String dataArrivoAlloZoo;
    public float altezza;
    public float peso;

    public Animale(String nome, String ciboPreferito, int eta, String dataArrivoAlloZoo, float altezza, float peso) {
        this.nome = nome;
        this.ciboPreferito = ciboPreferito;
        this.eta = eta;
        this.dataArrivoAlloZoo = dataArrivoAlloZoo;
        this.altezza = altezza;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public String getCiboPreferito() {
        return ciboPreferito;
    }

    public int getEta() {
        return eta;
    }

    public String getDataArrivoAlloZoo() {
        return dataArrivoAlloZoo;
    }

    public float getAltezza() {
        return altezza;
    }

    public float getPeso() {
        return peso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCiboPreferito(String ciboPreferito) {
        this.ciboPreferito = ciboPreferito;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public void setDataArrivoAlloZoo(String dataArrivoAlloZoo) {
        this.dataArrivoAlloZoo = dataArrivoAlloZoo;
    }

    public void setAltezza(float altezza) {
        this.altezza = altezza;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}
