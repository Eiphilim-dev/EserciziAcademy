package EserciziGiorno9.Esercizio7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
        System.out.print("Inserisci un numero intero: ");
        int num = scanner.nextInt();
        System.out.println(num);

        } catch(InputMismatchException e) {
            System.out.println("Non puoi inserire un carattere o un numero decimale: " + e.getMessage());
        
        } finally {
            scanner.close();
        }
    }
}
