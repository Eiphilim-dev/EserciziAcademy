package EsercitazionePersonale.Esercizio2;

public abstract class Personaggio {
    protected String nome;
    protected int puntiVita;
    protected int livello;
    protected int attacco;
    protected int difesa;

    public Personaggio(String nome, int puntiVita, int livello, int attacco, int difesa) {
        this.nome = nome;
        this.puntiVita = puntiVita;
        this.livello = livello;
        this.attacco = attacco;
        this.difesa = difesa;
    }

    public String getNome() {
        return nome;
    }

    public int getPuntiVita() {
        return puntiVita;
    }

    public int getLivello() {
        return livello;
    }

    public int getAttacco() {
        return attacco;
    }

    public int getDifesa() {
        return difesa;
    }

    public boolean isVivo() {
        return puntiVita > 0;
    }

    public void subisciDanno(int danno) {
        int dannoReale = danno - difesa;

        if (dannoReale < 0) {
            dannoReale = 0;
        }

        puntiVita -= dannoReale;

        if (puntiVita < 0) {
            puntiVita = 0;
        }

        System.out.println(nome + " subisce " + dannoReale + " danni. PV rimasti: " + puntiVita);
    }

    public void stampaScheda() {
        System.out.println("Nome: " + nome);
        System.out.println("Punti vita: " + puntiVita);
        System.out.println("Livello: " + livello);
        System.out.println("Attacco: " + attacco);
        System.out.println("Difesa: " + difesa);
    }

    public abstract void attacca(Personaggio bersaglio);

    @Override
    public String toString() {
        return nome + " [PV=" + puntiVita +
                ", livello=" + livello +
                ", attacco=" + attacco +
                ", difesa=" + difesa + "]";
    }
}
