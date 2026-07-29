package EserciziGiorno4;

import java.util.Scanner;

public class ArrayInteri {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //Creare una classe Java che abbia all’interno un array di interi contenente i numeri da 0 a 9.
        //  Stampare l’array a schermo.

        int numeriInt[] = new int[10];

        System.out.println("\nEsercizio 1\n");

        for (int i = 0; i < numeriInt.length; i++) {
            numeriInt[i] = (i);
            System.out.print(numeriInt[i] + " ");
        }


        //Creare una classe Java che abbia all’interno un array di interi contenente
        //i numeri pari da 0 a 12. Stampare l’array a schermo.

        int numeriInt2[] = new int[13];

        System.out.println("\n\nEsercizio 2\n");

        for (int i = 0; i < numeriInt2.length; i++) {
            numeriInt2[i] = (i);
            if (numeriInt2[i] % 2 == 0) {
                System.out.print(numeriInt2[i] + " ");

            }
        }

        //Creare una classe Java che abbia all’interno un array di interi contenente i numeri
        //dispari da -3 a 11. Stampare l’array a schermo.

        int numeriInt3[] = new int[15];

        System.out.println("\n\nEsercizio 3\n");

        for (int i = 0; i < numeriInt3.length; i++) {
            numeriInt3[i] = i - 3;
            if (numeriInt3[i] % 2 != 0) {
                System.out.print(numeriInt3[i] + " ");

            }
        }

        //Creare una classe Java che abbia all’interno un array di stringhe
        //scelte dal programmatore. Stampare l’array a schermo

        System.out.println("\n\nEsercizio 4\n");

        System.out.println("Inserisci una frase seguita da virgole dopo ogni parola.");
        String frase = scanner.nextLine();
        String[] nomi = frase.split(",");

        for (String nome : nomi) {
            System.out.println(nome.trim());
        }

        //Creare una classe Java che abbia all’interno un array di interi contenente dei numeri
        //scelti dal programmatore. Stampare la somma di tutti gli elementi dell’array a schermo.

        System.out.println("\n\nEsercizio 5\n");

        int[] arrayInt5 = new int[]{5, 7, 9, 2};
        int somma = 0;

        for (int i = 0; i < arrayInt5.length; i++) {
            somma += arrayInt5[i];
        }
        System.out.println(somma);

        //Creare una classe Java che abbia all’interno un array di interi contenente dei numeri scelti 
        // dal programmatore. Stampare la media di tutti gli elementi dell’array a schermo.

        System.out.println("\n\nEsercizio 6\n");

        int[] arrayInt6 = new int[]{5, 7, 9, 2};
        int media = 0;

        for (int i = 0; i < arrayInt6.length; i++) {
            media += arrayInt6[i];
        }
        System.out.println(media / (double) arrayInt6.length);

        //Creare una classe Java che abbia all’interno un array di interi, con numeri arbitrari definiti dalprogrammatore.
        //Con l’ausilio di una variabile, controllare che un numero sia nell’array.

        System.out.println("\n\nEsercizio 7\n");

        int[] arrayInt7 = {5, 7, 9, 8};

        System.out.print("Inserisci il numero che vuoi cercare: ");
        int risposta = scanner.nextInt();
        boolean trovato = false;

        for (int i : arrayInt7) {
            if (i == risposta) {
                trovato = true;
                break;

            }
        }
        if (trovato) {
            System.out.println("Esiste il numero: " + risposta);

        } else {
            System.out.println("Non esiste");

        }
        //Creare una classe Java che abbia all’interno un array di interi contenente dei numeri
        //scelti dal programmatore. Stampare il massimo tra tutti gli elementi dell’array a schermo.

        System.out.println("\n\nEsercizio 8\n");

        Scanner scann = new Scanner(System.in);
        System.out.println("Scegli dei numeri seguiti da una ,");
        String risposta1 = scann.nextLine();

        String[] pezziRisposta = risposta1.split(",");
        int[] arrayInt8 = new int[pezziRisposta.length];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < pezziRisposta.length; i++) {
            String testo = pezziRisposta[i].trim();
            arrayInt8[i] = Integer.parseInt(testo);

            if (arrayInt8[i] > max) {
                max = arrayInt8[i];

            }
        }
        System.out.println("Il massimo è: " + max);
        scann.close();
        scanner.close();
    }
}
