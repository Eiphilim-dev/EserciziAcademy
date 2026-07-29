package EserciziGiorno14.Esercizio4_6;

import java.util.Scanner;

public class TestLampadina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il numero massimo di click prima che la lampadina si rompa: ");
        int maxClick = scanner.nextInt();

        Lampadina lampadina = new Lampadina(maxClick);

        int scelta;

        do {
            System.out.println("\nScegli un'opzione:");
            System.out.println("1. Click");
            System.out.println("2. Stato lampadina");
            System.out.println("3. Stacca corrente");
            System.out.println("4. Riattiva corrente");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    lampadina.click();
                    System.out.println("Hai premuto l'interruttore.");
                    break;
                case 2:
                    System.out.println("Stato lampadina: " + lampadina.stato());
                    System.out.println("Corrente impianto: " + (Lampadina.isCorrente() ? "PRESENTE" : "ASSENTE"));
                    break;
                case 3:
                    Lampadina.staccaCorrente();
                    System.out.println("Corrente staccata.");
                    break;
                case 4:
                    Lampadina.attaccaCorrente();
                    System.out.println("Corrente riattivata.");
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