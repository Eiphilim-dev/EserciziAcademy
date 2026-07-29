package EserciziGiorno10.Esercizio1;

import java.util.ArrayList;
import java.util.Scanner;

public class DecrescenteIntMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<Integer>();
        System.out.println("Inserisci i numeri uno alla volta (scrivi -1 per finire):");

        int media = 0;
        while (true) {
            System.out.print("Inserisci numero: ");
            int numeroNuovo = scanner.nextInt();

            if (numeroNuovo == -1) {
                break;

            }
            
            if (!lista.isEmpty()) {
                int ultimoSalvato = lista.get(lista.size() - 1);
                int somma = 0;

                for (Integer integer : lista) {
                    somma += integer;

                }
                media = somma / lista.size();

                if (numeroNuovo < ultimoSalvato) {
                    System.out.println("Questo è più piccolo del precedente (" + ultimoSalvato + ")!");

                }
            }

            
            lista.add(numeroNuovo);
        }

        System.out.println("La tua lista finale è: " + lista + "\n" 
                            + "Hai inserito in totale " + lista.size() + " numeri\n"
                            + "La media dei numeri inseriti è: " + media);
        scanner.close();
    }
}
