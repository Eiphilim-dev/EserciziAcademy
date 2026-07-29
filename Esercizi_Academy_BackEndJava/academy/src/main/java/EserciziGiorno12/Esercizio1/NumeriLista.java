package EserciziGiorno12.Esercizio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumeriLista {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> lista = new ArrayList<>();

        System.out.println("Inserisci i numeri (digita -1 per terminare):");
        while (true) {
            int num = scanner.nextInt();
            if (num == -1) break;
            lista.add(num);
        }

        System.out.println("Lista inserita: " + lista);
        scanner.close();
    }
}
