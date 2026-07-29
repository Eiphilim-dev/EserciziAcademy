package EsercitazionePersonale.Esercizio2;

public class Arciere extends Personaggio {
    private int frecce;

    public Arciere(String nome, int puntiVita, int livello, int attacco, int difesa, int frecce) {
        super(nome, puntiVita, livello, attacco, difesa);
        this.frecce = frecce;
    }

    public int getFrecce() {
        return frecce;
    }

    @Override
    public void stampaScheda() {
        super.stampaScheda();
        System.out.println("Frecce: " + frecce);
    }

    @Override
    public void attacca(Personaggio bersaglio) {
        if (!isVivo()) {
            System.out.println(nome + " è stato sconfitto e non può attaccare.");
            return;
        }

        if (frecce > 0) {
            int danno = attacco + livello;
            frecce--;
            System.out.println(nome + " scocca una freccia contro " + bersaglio.getNome() + "!");
            bersaglio.subisciDanno(danno);
            System.out.println("Frecce rimaste: " + frecce);
        } else {
            System.out.println(nome + " non ha più frecce e non può attaccare!");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " [frecce=" + frecce + "]";
    }
}
