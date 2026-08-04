package model;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Motore {
    private String tipo;

    public Motore() {
        this.tipo = "Standard";
    }

    public Motore(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
