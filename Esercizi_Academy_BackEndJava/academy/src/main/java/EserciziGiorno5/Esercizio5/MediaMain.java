package EserciziGiorno5.Esercizio5;

public class MediaMain {
    public static void main(String[] args) {
        printAverage();
    }

    public static void printAverage() {
        int[] arrayInt6 = new int[]{5, 7, 9};
        int media = 0;

        for (int i = 0; i < arrayInt6.length; i++) {
            media += arrayInt6[i];
        }

        System.out.println("La media dei numeri è: " + media / (double) arrayInt6.length);
    }
}
