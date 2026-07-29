package EserciziGiorno10.Esercizio13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci lo username: ");
        String username = scanner.nextLine();

        System.out.print("Inserisci la password: ");
        String password = scanner.nextLine();

        try {
            if (username.contains(" ") || password.contains(" ")) {
                throw new checkSpazioException("Errore: username e password non possono contenere spazi vuoti!");

            }

            System.out.println("Registrazione effettuata!");

        } catch (checkSpazioException e) {
            System.out.println(e.getMessage());
            
        } finally {
            scanner.close();

        }
    }
}
