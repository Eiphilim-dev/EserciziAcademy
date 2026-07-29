package EserciziGiorno12.Esercizio2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InsiemeNumeri {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> insieme = new HashSet<>();

        System.out.println("Inserisci i numeri (digita -1 per terminare):");
        while (true) {
            int num = scanner.nextInt();
            if (num == -1) break;
            insieme.add(num);
        }

        System.out.println("Insieme inserito (senza duplicati): " + insieme);
        scanner.close();
    }
}
