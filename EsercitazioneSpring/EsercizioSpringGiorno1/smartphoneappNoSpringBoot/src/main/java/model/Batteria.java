package model;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Batteria {

    private String marca;
    private int carica;

    public Batteria() {
        this.marca = "Li-Ion 5000mAh";
        this.carica = 100;
        System.out.println("Costruttore chiamato da Spring.");
    }

    @PostConstruct
    public void init() {
        System.out.println("Inizializzazione batteria...");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Distruzione Bean Batteria.");
    }

    public void usa(int consumo) {
        this.carica = Math.max(0, this.carica - consumo);
        System.out.println("   Consumo in corso... Carica residua: " + carica + "%");
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCarica() {
        return carica;
    }

    public void setCarica(int carica) {
        this.carica = carica;
    }

    @Override
    public String toString() {
        return "Batteria{marca='" + marca + "', carica=" + carica + "%}";
    }
}
