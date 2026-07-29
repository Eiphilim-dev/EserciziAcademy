package EserciziGiorno10.Esercizio6_7;

public class ContrattoMobile extends ContrattoTelefonico{
    private static final double COSTO_RISPOSTA = 0.04;

    public ContrattoMobile(String numero, String nomeAbbonato, double bolletta) {
        super(numero, nomeAbbonato, bolletta);
    }

    public static double getCostoRisposta() {
        return COSTO_RISPOSTA;
    }
}
