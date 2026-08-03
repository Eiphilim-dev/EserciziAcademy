package model;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Smartphone {
    private final Batteria batteria;

    @Autowired
    public Smartphone(Batteria batteria) {
        this.batteria = batteria;
        System.out.println("Costruttore chiamato da Spring e Batteria iniettata.");
    }

    @PostConstruct
    public void init() {
        System.out.println("Inizializzazione Sistema...");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Distruzione Bean Smartphone.");
    }

    public void accendi() {
        System.out.println("Dispositivo acceso! Stato: " + batteria);
    }

    public void avviaGioco() {
        System.out.println("Avvio gioco...");
        batteria.usa(30);
    }

    public Batteria getBatteria() {
        return batteria;
    }
}
