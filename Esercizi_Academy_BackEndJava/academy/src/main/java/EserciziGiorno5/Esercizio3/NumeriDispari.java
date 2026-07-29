package EserciziGiorno5.Esercizio3;

public class NumeriDispari {
    public static void main(String[] args) {
        int i = 14;
        while (i >= -3) {
            if (i % 2 != 0) {
                System.out.print(i + " ");

            }
            i--;
        }

        System.out.println("\n- - - - -");

        for (i = 14; i >= -3; i--) {
            if (i % 2 != 0) {
                System.out.print(i + " ");

            }
        }
    }
}
