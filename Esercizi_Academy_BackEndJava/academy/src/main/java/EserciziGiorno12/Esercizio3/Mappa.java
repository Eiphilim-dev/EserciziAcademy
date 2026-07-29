package EserciziGiorno12.Esercizio3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mappa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> mappa = new HashMap<>();

        // Inserimento di 3 elementi
        for (int i = 1; i <= 3; i++) {
            System.out.print("Inserisci la chiave " + i + " (intero): ");
            int chiave = scanner.nextInt();
            scanner.nextLine(); // Pulizia del buffer
            System.out.print("Inserisci il valore per la chiave " + chiave + " (stringa): ");
            String valore = scanner.nextLine();
            
            mappa.put(chiave, valore);
        }

        // Ricerca per chiave
        System.out.print("\nScegli una chiave per vederne il valore: ");
        int chiaveScelta = scanner.nextInt();

        if (mappa.containsKey(chiaveScelta)) {
            System.out.println("Valore associato: " + mappa.get(chiaveScelta));
        } else {
            System.out.println("Chiave non trovata nella mappa!");
        }
        scanner.close();
    }
}
