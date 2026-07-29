package EserciziGiorno14.Esercizio12;

public class GestioneFlotta {
    private Veicolo[] flotta;
    private int numeroVeicoli;

    public GestioneFlotta(int capacitaMassima) {
        flotta = new Veicolo[capacitaMassima];
        numeroVeicoli = 0;
    }

    public void aggiungiVeicolo(Veicolo veicolo) {
        if (numeroVeicoli < flotta.length) {
            flotta[numeroVeicoli] = veicolo;
            numeroVeicoli++;
            System.out.println("Veicolo aggiunto con successo.");
        } else {
            System.out.println("Flotta piena, impossibile aggiungere altri veicoli.");
        }
    }

    public void visualizzaVeicoli() {
        if (numeroVeicoli == 0) {
            System.out.println("Nessun veicolo presente.");
            return;
        }

        for (int i = 0; i < numeroVeicoli; i++) {
            System.out.println("\nVeicolo " + (i + 1));
            flotta[i].stampaDettagli();
        }
    }

    public void rimuoviVeicolo(String targa) {
        for (int i = 0; i < numeroVeicoli; i++) {
            if (flotta[i].getTarga().equalsIgnoreCase(targa)) {
                for (int j = i; j < numeroVeicoli - 1; j++) {
                    flotta[j] = flotta[j + 1];
                }
                flotta[numeroVeicoli - 1] = null;
                numeroVeicoli--;
                System.out.println("Veicolo rimosso con successo.");
                return;
            }
        }
        System.out.println("Veicolo non trovato.");
    }

    public void impostaNonDisponibile(String modello) {
        for (int i = 0; i < numeroVeicoli; i++) {
            if (flotta[i].getModello().equalsIgnoreCase(modello)) {
                if (flotta[i].isDisponibile()) {
                    flotta[i].setDisponibile(false);
                    System.out.println("Veicolo noleggiato, ora non disponibile.");
                } else {
                    System.out.println("Veicolo già non disponibile.");
                }
                return;
            }
        }
        System.out.println("Veicolo non trovato.");
    }

    public double calcolaCostoTotale(String modello, int giorni) {
        for (int i = 0; i < numeroVeicoli; i++) {
            if (flotta[i].getModello().equalsIgnoreCase(modello)) {
                return flotta[i].calcolaCostoNoleggio(giorni);
            }
        }
        return -1;
    }
}
