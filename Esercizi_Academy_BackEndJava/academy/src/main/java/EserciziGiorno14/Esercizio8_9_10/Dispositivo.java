package EserciziGiorno14.Esercizio8_9_10;

public class Dispositivo {
    private String marca;
    private String modello;
    private double prezzo;
    private SistemaOperativo sistemaOperativo;

    public Dispositivo(String marca, String modello, double prezzo, SistemaOperativo sistemaOperativo) {
        this.marca = marca;
        this.modello = modello;
        this.prezzo = prezzo;
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public SistemaOperativo getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void stampaDettagli() {
        System.out.println("Marca: " + marca);
        System.out.println("Modello: " + modello);
        System.out.println("Prezzo: " + prezzo);
        System.out.println("Sistema operativo: " + sistemaOperativo);
    }
}