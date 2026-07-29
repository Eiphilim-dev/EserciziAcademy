package EserciziGiorno10.Esercizio6_7;

public class ContrattoFisso extends ContrattoTelefonico{
    private String indirizzoUtenza;

    public ContrattoFisso(String numero, String nomeAbbonato, double bolletta, String indirizzoUtenza) {
        super(numero, nomeAbbonato, bolletta);
        this.indirizzoUtenza = indirizzoUtenza;
    }

    public String getIndirizzoUtenza() {
        return indirizzoUtenza;
    }
}
