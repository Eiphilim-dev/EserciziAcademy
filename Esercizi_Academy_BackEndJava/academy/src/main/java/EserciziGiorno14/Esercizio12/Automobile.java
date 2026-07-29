package EserciziGiorno14.Esercizio12;

public class Automobile extends Veicolo {
    private int numeroPosti;

    public Automobile(String modello, String targa, int annoImmatricolazione, double costoGiornaliero, int numeroPosti) {
        super(modello, targa, annoImmatricolazione, costoGiornaliero);
        this.numeroPosti = numeroPosti;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    @Override
    public void stampaDettagli() {
        System.out.println("AUTOMOBILE");
        System.out.println("Modello: " + getModello());
        System.out.println("Targa: " + getTarga());
        System.out.println("Anno immatricolazione: " + getAnnoImmatricolazione());
        System.out.println("Costo giornaliero: " + getCostoGiornaliero());
        System.out.println("Numero posti: " + numeroPosti);
        System.out.println("Disponibile: " + isDisponibile());
    }
}
