package EserciziGiorno5.Esercizio10;

import java.util.Scanner;

public class ControlloNumMaggiore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un numero");
        int num1 = scanner.nextInt();

        System.out.println("Inserisci il secondo numero");
        int num2 = scanner.nextInt();

        if (num1 > num2) {
            System.out.println("Il primo numero è maggiore");

        } else {
            System.out.println("Il primo numero non è maggiore");

        }
        scanner.close();
    }
}
