public class VideogiocoCompetitivo extends Videogioco implements Multiplayer {
    private int punteggio;

    public VideogiocoCompetitivo(String nome, double prezzo, int pegi, int punteggio) {
        super(nome, prezzo, pegi);
        this.punteggio = punteggio;
    }

    public int getPunteggio() { return punteggio; }
    public void setPunteggio(int punteggio) { this.punteggio = punteggio; }

    @Override
    public void gioca() {
        System.out.println("Sta giocando al videogioco competitivo " + getNome());
    }

    @Override
    public void sfida() {
        System.out.println("Sfida in corso su " + getNome());
    }

    @Override
    public String toString() {
        return super.toString() + ", Punteggio: " + punteggio;
    }
}