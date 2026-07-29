package EserciziGiorno10.Esercizio6_7;

public abstract class ContrattoTelefonico {
    private String numero;
    private String nomeAbbonato;
    private double bolletta;
    private static final double COSTO_AL_SECONDO = 0.05;
    
    public ContrattoTelefonico(String numero, String nomeAbbonato, double bolletta) {
        this.numero = numero;
        this.nomeAbbonato = nomeAbbonato;
        this.bolletta = bolletta;
    }

    public void chiama(ContrattoTelefonico cff, String numero, int secondiTelefonata) {
        try {
                double costoTotMobile = 0.0;

            if (cff instanceof ContrattoMobile) {
                costoTotMobile = calcolaCostoTelefonata(secondiTelefonata) + ContrattoMobile.getCostoRisposta();

                System.out.println("Sto chiamando il numero " + numero);
                Thread.sleep(4000);
                System.out.println("Chiamata terminata: il costo sarà di " + costoTotMobile + " euro");

            } else {
            System.out.println("Sto chiamando il numero " + numero);
            Thread.sleep(4000);
            System.out.println("Chiamata terminata: il costo sarà di " + calcolaCostoTelefonata(secondiTelefonata) + " euro");

            }
            this.bolletta += costoTotMobile;
 
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

    public double calcolaCostoTelefonata(int secondiChiamata) {
        this.bolletta += (secondiChiamata * COSTO_AL_SECONDO);
        return secondiChiamata * COSTO_AL_SECONDO;

    }


    public String getNumero() {
        return numero;
    }

    public String getNomeAbbonato() {
        return nomeAbbonato;
    }

    public double getBolletta() {
        return bolletta;
    }

    public static double getCostoAlSecondo() {
        return COSTO_AL_SECONDO;

    }
}
