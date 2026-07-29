package EserciziGiorno14.Esercizio12;

public class Furgone extends Veicolo {
    private double capacitaCarico;

    public Furgone(String modello, String targa, int annoImmatricolazione, double costoGiornaliero, double capacitaCarico) {
        super(modello, targa, annoImmatricolazione, costoGiornaliero);
        this.capacitaCarico = capacitaCarico;
    }

    public double getCapacitaCarico() {
        return capacitaCarico;
    }

    @Override
    public void stampaDettagli() {
        System.out.println("FURGONE");
        System.out.println("Modello: " + getModello());
        System.out.println("Targa: " + getTarga());
        System.out.println("Anno immatricolazione: " + getAnnoImmatricolazione());
        System.out.println("Costo giornaliero: " + getCostoGiornaliero());
        System.out.println("Capacità di carico: " + capacitaCarico + " kg");
        System.out.println("Disponibile: " + isDisponibile());
    }
}
