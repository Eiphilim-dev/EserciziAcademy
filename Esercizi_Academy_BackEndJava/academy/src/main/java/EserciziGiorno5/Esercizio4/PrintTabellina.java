package EserciziGiorno5.Esercizio4;

public class PrintTabellina {
    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            System.out.println("\nTabellina del numero: " + i + "");

            for (int j = 1; j <= 10; j++) {
                int risultato = j * i;
                System.out.println(i + " x " + j + " = " + risultato);

            }
        }
    }
}
