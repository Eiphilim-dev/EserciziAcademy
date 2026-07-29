package EserciziGiorno2.Esercizio1;

public class Smartphone {
    private String marca;
    private String modello;
    private double dimensioneSchermo;
    private int memoria;

    public Smartphone(String marca, String modello, double dimensioneSchermo, int memoria) {
        this.marca = marca;
        this.modello = modello;
        this.dimensioneSchermo = dimensioneSchermo;
        this.memoria = memoria;
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

    public double getDimensioneSchermo() {
        return dimensioneSchermo;
    }

    public void setDimensioneSchermo(double dimensioneSchermo) {
        this.dimensioneSchermo = dimensioneSchermo;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }
}
