package EserciziGiorno14.Esercizio12;

public class Main {
    public static void main(String[] args) {
        GestioneFlotta gestione = new GestioneFlotta(10);

        Veicolo v1 = new Automobile("Fiat Panda", "AB123CD", 2020, 45.0, 5);
        Veicolo v2 = new Furgone("Iveco Daily", "EF456GH", 2019, 80.0, 1200);
        Veicolo v3 = new Motociclo("Yamaha MT-07", "IJ789KL", 2021, 35.0, 700);

        gestione.aggiungiVeicolo(v1);
        gestione.aggiungiVeicolo(v2);
        gestione.aggiungiVeicolo(v3);

        System.out.println("\n--- ELENCO VEICOLI ---");
        gestione.visualizzaVeicoli();

        System.out.println("\n--- CALCOLO COSTO NOLEGGIO ---");
        double costo = gestione.calcolaCostoTotale("Fiat Panda", 3);
        if (costo != -1) {
            System.out.println("Costo totale noleggio per 3 giorni: " + costo + " euro");
        } else {
            System.out.println("Veicolo non trovato.");
        }

        System.out.println("\n--- NOLEGGIO VEICOLO ---");
        gestione.impostaNonDisponibile("Fiat Panda");
        gestione.visualizzaVeicoli();

        System.out.println("\n--- RIMOZIONE VEICOLO ---");
        gestione.rimuoviVeicolo("EF456GH");
        gestione.visualizzaVeicoli();
    }
}
