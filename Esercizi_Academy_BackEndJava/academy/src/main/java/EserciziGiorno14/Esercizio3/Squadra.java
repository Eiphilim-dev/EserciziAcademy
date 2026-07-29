package EserciziGiorno14.Esercizio3;

import java.util.ArrayList;
import java.util.List;

public class Squadra {
    private String nome;
    private double capitaleSociale;
    private List<Giocatore> giocatori;

    public Squadra(String nome, double capitaleSociale) {
        this.nome = nome;
        this.capitaleSociale = capitaleSociale;
        this.giocatori = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public double getCapitaleSociale() {
        return capitaleSociale;
    }

    public List<Giocatore> getGiocatori() {
        return giocatori;
    }

    public boolean acquistaGiocatore(Giocatore giocatore) {
        if (giocatore.getPrezzo() > capitaleSociale) {
            System.out.println("Capitale insufficiente per acquistare " + giocatore.getNome());
            return false;
        }
        giocatori.add(giocatore);
        capitaleSociale -= giocatore.getPrezzo();
        System.out.println(giocatore.getNome() + " acquistato dalla squadra " + nome);
        return true;
    }

    public boolean vendiGiocatore(Giocatore giocatore, double prezzoVendita) {
        if (!giocatori.contains(giocatore)) {
            System.out.println(giocatore.getNome() + " non appartiene a " + nome);
            return false;
        }
        giocatori.remove(giocatore);
        capitaleSociale += prezzoVendita;
        System.out.println(giocatore.getNome() + " venduto dalla squadra " + nome);
        return true;
    }

    @Override
    public String toString() {
        return "Squadra: " + nome +
               "\nCapitale sociale: €" + capitaleSociale +
               "\nGiocatori: " + giocatori;
    }
}
