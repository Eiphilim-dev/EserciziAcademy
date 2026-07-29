package EserciziGiorno5.Esercizio2;

public class NumeriPari {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 14) {
            if (i % 2 == 0) {
                System.out.print(i + " ");

            }
            i++;
        }

        System.out.println("\n- - - - -");

        for (i = 1; i <= 14; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");

            }
        }
    }
}
