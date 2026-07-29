package EserciziGiorno2.Esercizio3;

public class Viaggio {
    private String nomeLocalita;
    private int durataViaggio;
    private double costoViaggio;
    private int postiDisponibili;

    public Viaggio(String nomeLocalita, int durataViaggio, double costoViaggio, int postiDisponibili) {
        this.nomeLocalita = nomeLocalita;
        this.durataViaggio = durataViaggio;
        this.costoViaggio = costoViaggio;
        this.postiDisponibili = postiDisponibili;
    }

    public boolean prenotaPosti(int numPostiDaPrenotare) {

        if (this.isSoldOut()) {
            System.out.println("Spiacenti, il viaggio è Sold Out!");
            return false;

        } else if (numPostiDaPrenotare <= numPostiDaPrenotare) {
            this.postiDisponibili -= numPostiDaPrenotare;
            System.out.println("Posti prenotati!");
            return false;

        } else {
            System.out.println("Mi dispiace il numeroDiPosti richiesti non è disponibile");
            return false;
        }
    }

    public boolean isSoldOut() {
        if (postiDisponibili == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String getDescrizione() {
        String giorni = (durataViaggio == 1) ? "giorno" : "giorni";

        return "Il viaggio a " + nomeLocalita +
                " ha una durata di " + durataViaggio + " " + giorni +
                " e un costo di " + costoViaggio + " euro.";
    }


    public String getNomeLocalita() {
        return nomeLocalita;
    }

    public void setNomeLocalita(String nomeLocalita) {
        this.nomeLocalita = nomeLocalita;
    }

    public int getDurataViaggio() {
        return durataViaggio;
    }

    public void setDurataViaggio(int durataViaggio) {
        this.durataViaggio = durataViaggio;
    }

    public double getCostoViaggio() {
        return costoViaggio;
    }

    public void setCostoViaggio(double costoViaggio) {
        this.costoViaggio = costoViaggio;
    }
}
