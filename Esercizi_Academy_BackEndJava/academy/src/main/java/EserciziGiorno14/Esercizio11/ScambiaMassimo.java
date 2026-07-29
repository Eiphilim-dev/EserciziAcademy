package EserciziGiorno14.Esercizio11;

import java.util.Scanner;

public class ScambiaMassimo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        do {
            System.out.print("Quanti elementi vuoi inserire? ");
            while (!scanner.hasNextInt()) {
                System.out.println("Devi inserire un numero intero.");
                scanner.next();
            }
            n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("La dimensione deve essere maggiore di 0.");
            }
        } while (n <= 0);

        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Inserisci l'elemento in posizione " + i + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Devi inserire un numero intero.");
                scanner.next();
            }
            array[i] = scanner.nextInt();
        }

        int indice;
        do {
            System.out.print("Scegli un indice tra 0 e " + (array.length - 1) + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Devi inserire un numero intero.");
                scanner.next();
            }
            indice = scanner.nextInt();

            if (indice < 0 || indice >= array.length) {
                System.out.println("Indice non valido.");
            }
        } while (indice < 0 || indice >= array.length);

        int indiceMassimo = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[indiceMassimo]) {
                indiceMassimo = i;
            }
        }

        if (indice == indiceMassimo) {
            System.out.println("L'indice scelto coincide con la posizione del massimo. Nessuno scambio necessario.");
        } else {
            int temp = array[indice];
            array[indice] = array[indiceMassimo];
            array[indiceMassimo] = temp;
            System.out.println("Scambio effettuato.");
        }

        System.out.print("Array finale: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        scanner.close();
    }
}