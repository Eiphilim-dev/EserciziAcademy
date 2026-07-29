package EserciziGiorno14.Esercizio5;

import EserciziGiorno14.Esercizio4_6.Lampadina;

public class Interruttore {
    private Lampadina lampadina;
    private String nome;

    public Interruttore(String nome, Lampadina lampadina) {
        this.nome = nome;
        this.lampadina = lampadina;
    }

    public String getNome() {
        return nome;
    }

    public void aziona() {
        lampadina.click();
    }

    public String statoLampadina() {
        return lampadina.stato();
    }
}
