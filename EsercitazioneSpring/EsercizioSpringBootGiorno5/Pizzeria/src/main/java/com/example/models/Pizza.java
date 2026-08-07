package com.example.models;


public class Pizza {

    private String tipo;
    private double prezzo;

    public Pizza() {
    }

    public Pizza(String tipo, double prezzo) {
        this.tipo = tipo;
        this.prezzo = prezzo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "tipo='" + tipo + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }
}
