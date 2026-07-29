package EsercitazionePersonale.Esercizio2;

import java.util.ArrayList;
import java.util.List;

public class Videogioco {
    public static void main(String[] args) {
        List<Personaggio> personaggi = new ArrayList<>();

        personaggi.add(new Guerriero("Arthur", 120, 5, 20, 8));
        personaggi.add(new Mago("Merlino", 90, 6, 18, 4, 30));
        personaggi.add(new Arciere("Legolas", 100, 5, 16, 5, 3));

        System.out.println("=== SCHEDA PERSONAGGI ===");
        for (Personaggio p : personaggi) {
            p.stampaScheda();
            System.out.println("----------------------");
        }

        Personaggio bersaglio = new Guerriero("Orco", 150, 4, 15, 6);

        System.out.println("\n=== INIZIO ATTACCHI ===");
        for (Personaggio p : personaggi) {
            p.attacca(bersaglio);
            System.out.println();
        }

        System.out.println("=== STATO FINALE DEL BERSAGLIO ===");
        System.out.println(bersaglio);

        System.out.println("\n=== STATO FINALE DI TUTTI I PERSONAGGI ===");
        for (Personaggio p : personaggi) {
            System.out.println(p);
        }
    }
}
