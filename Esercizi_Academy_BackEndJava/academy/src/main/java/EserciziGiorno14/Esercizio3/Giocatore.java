package EserciziGiorno14.Esercizio3;

public class Giocatore {
    private String nome;
    private double prezzo;

    public Giocatore(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return nome + " (€" + prezzo + ")";
    }
}