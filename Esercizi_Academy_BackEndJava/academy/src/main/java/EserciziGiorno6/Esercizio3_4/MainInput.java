package EserciziGiorno6.Esercizio3_4;

import java.util.Scanner;

public class MainInput {
    private static int contatore = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeri = {1, 25, -4, 36, 0, -1, -4, 27, 3, -1, -1, 52};
        boolean flag = false;

        System.out.print("Inserisci un numero: ");
        int risposta = scanner.nextInt();

        for (int numero : numeri) {
            if(risposta == numero) {
                flag = true;
                conta();

            }
        }

        if (flag) {
            System.out.println("Il numero è presente in totale " + contatore + " volte");

        } else {
            System.out.println("Il numero non è presente");

        }
        scanner.close();
    }

    public static void conta() {
        contatore += 1;
    }
}
