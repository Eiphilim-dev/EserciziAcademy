package EserciziGiorno14.Esercizio1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InputMismatchException{
        try(Scanner scanner = new Scanner(System.in)) {  
            List<Double> lista = new ArrayList<>();

            System.out.println("Inserisci i numeri uno alla volta (scrivi -1 per finire):");

            while (true) {
                System.out.print("Inserisci numero: ");
                double numeroNuovo = scanner.nextDouble();

                if(numeroNuovo == -1) {
                    break;

                }
                lista.add(numeroNuovo);  
            }
            if (!lista.isEmpty()) {
                    System.out.println("La tua lista finale è: " + lista + "\n"); 
                    OperazioniMath.getMax(lista);
                    OperazioniMath.getAverage(lista);

           }
        }   
    }
}
