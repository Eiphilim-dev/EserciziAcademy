package EserciziGiorno10.Esercizio12;

public class Bicicletta {
    private String marca;
    private String modello;
    private String tipo;
    private double prezzoVendita;

    public Bicicletta(String marca, String modello, String tipo, double prezzoVendita) {
        this.marca = marca;
        this.modello = modello;
        this.tipo = tipo;
        this.prezzoVendita = prezzoVendita;
    }

    public Bicicletta comparaPiuCostosa(Bicicletta altraBici) {
        if (this.prezzoVendita >= altraBici.getPrezzoVendita()) {
            return this;
        } else {
            return altraBici;
        }
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrezzoVendita() {
        return prezzoVendita;
    }

    public void setPrezzoVendita(double prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
    }

    @Override
    public String toString() {
        return marca + " " + modello + " (" + tipo + ") - " + prezzoVendita + "€";
    }
}
