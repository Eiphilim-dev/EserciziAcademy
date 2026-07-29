package EserciziGiorno14.Esercizio8_9_10;

public class Computer extends Dispositivo {
    private String tipoPeriferica;

    public Computer(String marca, String modello, double prezzo, SistemaOperativo sistemaOperativo) {
        super(marca, modello, prezzo, sistemaOperativo);
    }

    public void inserisciPeriferica(String periferica) {
        this.tipoPeriferica = periferica;
        System.out.println("Periferica inserita: " + periferica);
    }

    @Override
    public void stampaDettagli() {
        super.stampaDettagli();
        System.out.println("Periferica collegata: " + (tipoPeriferica != null ? tipoPeriferica : "Nessuna"));
    }
}
