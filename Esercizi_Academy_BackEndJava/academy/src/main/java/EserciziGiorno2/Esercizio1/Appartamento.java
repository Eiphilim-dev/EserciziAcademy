package EserciziGiorno2.Esercizio1;

public class Appartamento {
    private double superficie;
    private int numeroStanze;
    private int piano;

    public Appartamento() {
    }

    public Appartamento(double superficie, int numeroStanze, int piano) {
        this.superficie = superficie;
        this.numeroStanze = numeroStanze;
        this.piano = piano;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public int getNumeroStanze() {
        return numeroStanze;
    }

    public void setNumeroStanze(int numeroStanze) {
        this.numeroStanze = numeroStanze;
    }

    public int getPiano() {
        return piano;
    }

    public void setPiano(int piano) {
        this.piano = piano;
    }
}
