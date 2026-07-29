package EserciziGiorno10.Esercizio8_9;

@SuppressWarnings("all")
public class Studente extends Persona{
    private double mediaVoti;

    public Studente(String nome, String cognome, int eta) {
        super(nome, cognome, eta);
        this.mediaVoti = mediaVoti;
    }

    public void studia() {
        System.out.println("Sta studiando.");

    }

    public void calcolaMediaVoti(int... voti) {
        int sommaVoti = 0;
        for (int voto  : voti) {
            sommaVoti += voto;
        }
        this.mediaVoti = sommaVoti / (double) voti.length;
        System.out.println("La media dei voti di " + getNome() + " è: " + this.mediaVoti);

        }

    @Override
    public String toString() {
    return "Studente{nome='" + getNome() + "', cognome='" + getCognome() + "', eta=" + getEta() + "', mediaVoti=" + this.mediaVoti + "}";
    
    }

    public double getMediaVoti() {
        return mediaVoti;
    }

    public void setMediaVoti(double mediaVoti) {
        this.mediaVoti = mediaVoti;
    }
}
