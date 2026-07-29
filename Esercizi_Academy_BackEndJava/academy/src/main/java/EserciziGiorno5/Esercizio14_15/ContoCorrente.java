package EserciziGiorno5.Esercizio14_15;

public class ContoCorrente {
    private String numeroConto;
    private String intestatario;
    private double saldo;

    public ContoCorrente(String numeroConto, String intestatario, double saldo) {
        this.numeroConto = numeroConto;
        this.intestatario = intestatario;
        this.saldo = saldo;
    }

    void deposita(double importo) {
        if (importo > 0.0) {
           this.saldo += saldo;
           System.out.println("Hai depositato: " + importo + " euro");

        } else {
            System.out.println("L'importo deve essere maggiore di 0");
            
        }
    }

    boolean preleva(double importo) {
        boolean flag = false;

        if (importo <= getSaldo() && importo > 0) {
            System.out.println("Fondi prelevati");
            flag = true;
            return flag;

        } else {
            System.out.println("Saldo non disponibile");
            flag = false;
            return flag;

        }
    }

    void stampaConto() {
        System.out.println("\n--- INFORMAZIONI CONTO ---\n" 
                            + "Numero Conto: " + getNumeroConto() 
                            + "\nIntestatario: " + getIntestatario()
                            + "\nSaldo: " + getSaldo()
                          );
    }

    public String getNumeroConto() {
        return numeroConto;
    }

    public void setNumeroConto(String numeroConto) {
        this.numeroConto = numeroConto;
    }

    public String getIntestatario() {
        return intestatario;
    }

    public void setIntestatario(String intestatario) {
        this.intestatario = intestatario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
