package EserciziGiorno14.Esercizio5;

import java.util.Scanner;

import EserciziGiorno14.Esercizio4_6.Lampadina;

public class TestInterruttore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il numero massimo di click prima che la lampadina si rompa: ");
        int maxClick = scanner.nextInt();

        Lampadina lampadina = new Lampadina(maxClick);

        Interruttore interruttore1 = new Interruttore("Interruttore A", lampadina);
        Interruttore interruttore2 = new Interruttore("Interruttore B", lampadina);

        int scelta;

        do {
            System.out.println("\nQuale interruttore vuoi azionare?");
            System.out.println("1. " + interruttore1.getNome());
            System.out.println("2. " + interruttore2.getNome());
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    interruttore1.aziona();
                    System.out.println(interruttore1.getNome() + " azionato. Stato lampadina: " + interruttore1.statoLampadina());
                    break;
                case 2:
                    interruttore2.aziona();
                    System.out.println(interruttore2.getNome() + " azionato. Stato lampadina: " + interruttore2.statoLampadina());
                    break;
                case 0:
                    System.out.println("Programma terminato.");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 0);

        scanner.close();
    }
}
