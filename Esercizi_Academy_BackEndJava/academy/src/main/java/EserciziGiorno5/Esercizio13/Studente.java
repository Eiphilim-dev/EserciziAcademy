package EserciziGiorno5.Esercizio13;

public class Studente {
    private String nome;
    private int eta;
    private double votoMedio;
    
    public Studente(String nome, int eta, double votoMedio) {
        this.nome = nome;
        this.eta = eta;
        this.votoMedio = votoMedio;
    }

    public boolean isPromosso() {
        if (getVotoMedio() >= 6 && getVotoMedio() >= 0) {
            System.out.println("Sei promosso");
            return true;

        } else {
            System.out.println("Sei bocciato");
            return false;

        }
    }

    public void stampaInfo() {
        System.out.println("\n--- INFORMAZIONI STUDENTE ---\n" 
                            + "Nome: " + getNome() 
                            + "\nEtà: " + getEta() + " anni\n"
                            + "Voto medio: " + getVotoMedio()
                          );
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public double getVotoMedio() {
        return votoMedio;
    }

    public void setVotoMedio(double votoMedio) {
        this.votoMedio = votoMedio;
    }
}
