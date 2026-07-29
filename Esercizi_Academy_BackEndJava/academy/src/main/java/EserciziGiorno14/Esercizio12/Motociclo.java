package EserciziGiorno14.Esercizio12;

public class Motociclo extends Veicolo {
    private int cilindrata;

    public Motociclo(String modello, String targa, int annoImmatricolazione, double costoGiornaliero, int cilindrata) {
        super(modello, targa, annoImmatricolazione, costoGiornaliero);
        this.cilindrata = cilindrata;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    @Override
    public void stampaDettagli() {
        System.out.println("MOTOCICLO");
        System.out.println("Modello: " + getModello());
        System.out.println("Targa: " + getTarga());
        System.out.println("Anno immatricolazione: " + getAnnoImmatricolazione());
        System.out.println("Costo giornaliero: " + getCostoGiornaliero());
        System.out.println("Cilindrata: " + cilindrata + " cc");
        System.out.println("Disponibile: " + isDisponibile());
    }
}
