public class VideogiocoRpg extends Videogioco {
    private int puntiSalute;
    private int puntiMagia;

    public VideogiocoRpg(String nome, double prezzo, int pegi, int puntiSalute, int puntiMagia) {
        super(nome, prezzo, pegi);
        this.puntiSalute = puntiSalute;
        this.puntiMagia = puntiMagia;
    }

    public int getPuntiSalute() { return puntiSalute; }
    public void setPuntiSalute(int puntiSalute) { this.puntiSalute = puntiSalute; }

    public int getPuntiMagia() { return puntiMagia; }
    public void setPuntiMagia(int puntiMagia) { this.puntiMagia = puntiMagia; }

    @Override
    public void gioca() {
        System.out.println("Sta giocando al videogioco RPG " + getNome());
    }

    @Override
    public String toString() {
        return super.toString() + ", HP: " + puntiSalute + ", MP: " + puntiMagia;
    }
}

