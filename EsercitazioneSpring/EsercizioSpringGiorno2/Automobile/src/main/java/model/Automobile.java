package model;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Automobile {
    private String modello;
    private Motore motore;

    public Automobile() {
    }

    public Automobile(String modello) {
        this.modello = modello;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public Motore getMotore() {
        return motore;
    }

    public void setMotore(Motore motore) {
        this.motore = motore;
    }

    @PostConstruct
    public void init() {
        System.out.println("Automobile inizializzata: " + modello + " con motore: "
                + (motore != null ? motore.getTipo() : "Nessun motore"));

    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Automobile " + modello + " sta per essere rimossa da Spring");

    }

    public void mostraDettagli() {
        System.out.println("Auto: " + modello + " | Motore: " + (motore != null ? motore.getTipo() : "Nessun motore"));
    }
}
