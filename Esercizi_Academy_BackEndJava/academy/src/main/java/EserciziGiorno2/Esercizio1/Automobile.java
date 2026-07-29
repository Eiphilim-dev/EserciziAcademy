package EserciziGiorno2.Esercizio1;

public class Automobile {
    private String marca;
    private String modello;
    private final int N_RUOTE = 4;
    private double prezzo;

    public Automobile() {
    }

    public Automobile(String marca, String modello, double prezzo) {
        this.marca = marca;
        this.modello = modello;
        this.prezzo = prezzo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getN_RUOTE() {
        return N_RUOTE;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
