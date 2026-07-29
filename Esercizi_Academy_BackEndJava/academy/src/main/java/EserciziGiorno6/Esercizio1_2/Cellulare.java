package EserciziGiorno6.Esercizio1_2;

public class Cellulare {
    private String modello;
    private String proprietario;
    private String numeroCell;
    private double creditoResiduo;
    private String[] rubrica = new String[5];
    private String ultimoNumero;

    public Cellulare(String modello, String proprietario, String numeroCell, double creditoResiduo) {
        this.modello = modello;
        this.proprietario = proprietario;
        this.numeroCell = numeroCell;
        this.creditoResiduo = creditoResiduo;

    }

    public boolean aggiungiInRubrica(String nuovoNumero) {
    for (int i = 0; i < rubrica.length; i++) {
        if (rubrica[i] == null) {
            rubrica[i] = nuovoNumero;
            System.out.println("Numero " + nuovoNumero + " aggiunto in rubrica nella posizione " + i);
            return true;
        }
    }
    System.out.println("Impossibile aggiungere: rubrica piena!");
    return false;
    }

    public void stampaRubrica() {
    System.out.println("=== RUBRICA DI " + proprietario.toUpperCase() + " ===");
    
    boolean vuota = true;

    for (int i = 0; i < rubrica.length; i++) {
        if (rubrica[i] != null) {
            System.out.println((i + 1) + ". " + rubrica[i]);
            vuota = false;
        }
    }

    if (vuota) {
        System.out.println("La rubrica è vuota.");
    }
    
    System.out.println("=============================");
}

    public void chiama(String numeroDaChiamare) {
        boolean flag = false;
        if (creditoResiduo > 0.0) {
            this.ultimoNumero = numeroDaChiamare;

        for(String numeri : rubrica) {
            if (numeroDaChiamare.equals(numeri)) {
                flag = true;
                }
            }   
            if(flag) {
                System.out.println("Sto chiamando il numero: " + numeroDaChiamare);

            } else {
                    System.out.println("Il numero non è presente");
            }
        }
    }

    public void richiama() {
        System.out.println("Sto richiamando l'ultimo numero chiamato " + getUltimoNumero());
    
    }

    public void ricaricaCredito(double importo) {
        this.creditoResiduo += importo;
        System.out.println("Il credito ora è di: " + getCreditoResiduo());
        
    }

    public void ultimaChiamataEffettuata() {
            System.out.println("L'ultimo numero chiamato è: " + this.ultimoNumero);

    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getNumeroCell() {
        return numeroCell;
    }

    public void setNumeroCell(String numeroCell) {
        this.numeroCell = numeroCell;
    }

    public double getCreditoResiduo() {
        return creditoResiduo;
    }

    public void setCreditoResiduo(double creditoResiduo) {
        this.creditoResiduo = creditoResiduo;
    }

    public String getUltimoNumero() {
        return ultimoNumero;
    }

    public void setUltimoNumero(String ultimoNumero) {
        this.ultimoNumero = ultimoNumero;
    }
}
