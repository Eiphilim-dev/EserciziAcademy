package EserciziGiorno14.Esercizio12;

public abstract class Veicolo {
    private String modello;
    private String targa;
    private int annoImmatricolazione;
    private double costoGiornaliero;
    private boolean disponibile;

    public Veicolo(String modello, String targa, int annoImmatricolazione, double costoGiornaliero) {
        this.modello = modello;
        this.targa = targa;
        this.annoImmatricolazione = annoImmatricolazione;
        this.costoGiornaliero = costoGiornaliero;
        this.disponibile = true;
    }

    public String getModello() {
        return modello;
    }

    public String getTarga() {
        return targa;
    }

    public int getAnnoImmatricolazione() {
        return annoImmatricolazione;
    }

    public double getCostoGiornaliero() {
        return costoGiornaliero;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }

    public double calcolaCostoNoleggio(int giorni) {
        return costoGiornaliero * giorni;
    }

    public abstract void stampaDettagli();
}
