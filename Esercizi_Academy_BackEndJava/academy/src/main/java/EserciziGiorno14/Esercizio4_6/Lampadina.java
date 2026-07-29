package EserciziGiorno14.Esercizio4_6;

public class Lampadina {
    private boolean accesa;
    private boolean rotta;
    private int numeroClick;
    private int maxClick;

    private static boolean corrente = true;

    public Lampadina(int maxClick) {
        this.maxClick = maxClick;
        this.accesa = false;
        this.rotta = false;
        this.numeroClick = 0;
    }

    public String stato() {
        if (rotta) {
            return "ROTTA";
        }
        if (!corrente) {
            return "SPENTA";
        }
        if (accesa) {
            return "ACCESA";
        }
        return "SPENTA";
    }

    public void click() {
        if (rotta) {
            System.out.println("La lampadina è rotta.");
            return;
        }

        numeroClick++;

        if (numeroClick >= maxClick) {
            rotta = true;
            accesa = false;
            return;
        }

        accesa = !accesa;
    }

    public static void staccaCorrente() {
        corrente = false;
    }

    public static void attaccaCorrente() {
        corrente = true;
    }

    public static boolean isCorrente() {
        return corrente;
    }
}