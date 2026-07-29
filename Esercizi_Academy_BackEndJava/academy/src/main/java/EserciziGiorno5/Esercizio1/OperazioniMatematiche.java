package EserciziGiorno5.Esercizio1;

public class OperazioniMatematiche {
    public static void main(String[] args) {
        somma(2, 4);
        sottrazione(2, 10);
        moltiplicazione(10.3, 1.6);
        divisione(6, 2);
    }

    public static void somma(double n, double n2) {
        double sum = n + n2;
        System.out.println("La somma di: " + n + " + " + n2 + " è: " + sum);
    }

    public static void sottrazione(double n, double n2) {
        double sottr = n - n2;
        System.out.println("La sottrazione di: " + n + " + " + n2 + " è: " + sottr);
    }

    public static void moltiplicazione(double n, double n2) {
        double molt = n * n2;
        System.out.println("Il prodotto di: " + n + " + " + n2 + " è: " + molt);
    }

    public static void divisione(double n, double n2) {
        double divis = n / n2;
        System.out.println("La somma di: " + n + " + " + n2 + " è: " + divis);
    }
}
