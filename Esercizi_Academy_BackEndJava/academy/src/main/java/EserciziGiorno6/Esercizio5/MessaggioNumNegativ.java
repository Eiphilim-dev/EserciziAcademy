package EserciziGiorno6.Esercizio5;

import java.util.Scanner;

public class MessaggioNumNegativ {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Scegli dei numeri seguiti da una ,");
        String rispostaNum = scanner.nextLine();
        boolean flag = false;

        String[] pezziRisposta = rispostaNum.split(",");
        int[] arrayInt = new int[pezziRisposta.length];

        for(int i = 0; i < pezziRisposta.length; i++) {
            String testo = pezziRisposta[i].trim();
            arrayInt[i] = Integer.parseInt(testo);
            
            if (arrayInt[i] < 0) {
                    flag = true;
                }
            }

            if (flag) {
                System.out.println("L'array contiene numeri negativi");

            }
            scanner.close();
    }
}
