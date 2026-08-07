package com.example.models;

public class Ordinazione {

    private Pizza pizzaRossa;
    private Pizza pizzaBianca;

    public Ordinazione() {
    }

    public Ordinazione(Pizza pizzaRossa, Pizza pizzaBianca) {
        this.pizzaRossa = pizzaRossa;
        this.pizzaBianca = pizzaBianca;
    }

    public Pizza getPizzaRossa() {
        return pizzaRossa;
    }

    public void setPizzaRossa(Pizza pizzaRossa) {
        this.pizzaRossa = pizzaRossa;
    }

    public Pizza getPizzaBianca() {
        return pizzaBianca;
    }

    public void setPizzaBianca(Pizza pizzaBianca) {
        this.pizzaBianca = pizzaBianca;
    }

    public void mostraDettagli() {
        System.out.println("Ordinazione:");
        System.out.println("Pizza rossa: " + pizzaRossa);
        System.out.println("Pizza bianca: " + pizzaBianca);
    }

    @Override
    public String toString() {
        return "Ordinazione{" +
                "pizzaRossa=" + pizzaRossa +
                ", pizzaBianca=" + pizzaBianca +
                '}';
    }
}