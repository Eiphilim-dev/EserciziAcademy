package EserciziGiorno10.Esercizio10;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{5, 4, 3, 2, 1};
        System.out.println(decrescente(array));
    }

    public static boolean decrescente(int[] a) {
    for (int i = 0; i < a.length - 1; i++) {
        if (a[i] < a[i + 1]) {
            return false;
            }
        }   
        return true;
    }
}
