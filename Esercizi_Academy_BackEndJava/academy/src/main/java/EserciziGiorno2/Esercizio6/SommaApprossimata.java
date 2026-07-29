package EserciziGiorno2.Esercizio6;

public class SommaApprossimata {
    public static void main(String[] args) {
        SommaInt(12.21, 23.53);
    }

    public static void SommaInt(double num1, double num2) {
        int risultatoInt = (int) (num1 + num2);
        System.out.println("Risultato: " + risultatoInt);
    }
}
