package EserciziGiorno14.Esercizio2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InputMismatchException{
        List<Integer> lista = new ArrayList<>();
        
        try(Scanner scanner = new Scanner(System.in)) {  
            System.out.println("Inserisci i numeri positivi uno alla volta:");

            while (true) {
                System.out.print("Inserisci numero: ");
                int numeroNuovo = scanner.nextInt();
                
                if(numeroNuovo < 0) {
                    System.out.println("Lista terminata");
                    break;

                } else {
                    lista.add(numeroNuovo);
                }
                
            }
            System.out.print("Inserisci un'altro numero:");
            int numeroNuovo2 = scanner.nextInt();

            if (!lista.isEmpty()) {
                OperazioniMath.getMultipli(lista, numeroNuovo2);
                OperazioniMath.getListaNoMultipli(lista, numeroNuovo2);
            }
        }   
    }
}
