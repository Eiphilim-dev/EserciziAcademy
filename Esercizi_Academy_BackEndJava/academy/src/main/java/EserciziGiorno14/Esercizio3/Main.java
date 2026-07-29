package EserciziGiorno14.Esercizio3;

public class Main {
    public static void main(String[] args) {
        Squadra squadra = new Squadra("Rossoblu FC", 100000);

        Giocatore g1 = new Giocatore("Mario Rossi", 30000);
        Giocatore g2 = new Giocatore("Luca Bianchi", 25000);

        squadra.acquistaGiocatore(g1);
        squadra.acquistaGiocatore(g2);

        System.out.println(squadra);

        squadra.vendiGiocatore(g1, 35000);

        System.out.println(squadra);
    }
}

    

