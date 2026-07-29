package EserciziGiorno14.Esercizio8_9_10;

public class GestioneInventario {
    private Dispositivo[] inventario;
    private int numeroDispositivi;

    public GestioneInventario(int capacita) {
        inventario = new Dispositivo[capacita];
        numeroDispositivi = 0;
    }

    public void aggiungiDispositivo(Dispositivo dispositivo) {
        if (numeroDispositivi < inventario.length) {
            inventario[numeroDispositivi] = dispositivo;
            numeroDispositivi++;
            System.out.println("Dispositivo aggiunto.");
        } else {
            System.out.println("Inventario pieno.");
        }
    }

    public void rimuoviDispositivo(String modello) {
        for (int i = 0; i < numeroDispositivi; i++) {
            if (inventario[i].getModello().equalsIgnoreCase(modello)) {
                for (int j = i; j < numeroDispositivi - 1; j++) {
                    inventario[j] = inventario[j + 1];
                }
                inventario[numeroDispositivi - 1] = null;
                numeroDispositivi--;
                System.out.println("Dispositivo rimosso.");
                return;
            }
        }
        System.out.println("Dispositivo non trovato.");
    }

    public void stampaInventario() {
        if (numeroDispositivi == 0) {
            System.out.println("Inventario vuoto.");
            return;
        }

        for (int i = 0; i < numeroDispositivi; i++) {
            System.out.println("\nDispositivo " + (i + 1));
            inventario[i].stampaDettagli();
        }
    }

    public Dispositivo[] getInventario() {
        return inventario;
    }

    public int getNumeroDispositivi() {
        return numeroDispositivi;
    }
}