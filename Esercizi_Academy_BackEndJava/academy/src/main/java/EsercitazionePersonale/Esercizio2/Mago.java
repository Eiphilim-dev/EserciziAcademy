package EsercitazionePersonale.Esercizio2;

public class Mago extends Personaggio {
    private int mana;

    public Mago(String nome, int puntiVita, int livello, int attacco, int difesa, int mana) {
        super(nome, puntiVita, livello, attacco, difesa);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    @Override
    public void stampaScheda() {
        super.stampaScheda();
        System.out.println("Mana: " + mana);
    }

    @Override
    public void attacca(Personaggio bersaglio) {
        if (!isVivo()) {
            System.out.println(nome + " è stato sconfitto e non può attaccare.");
            return;
        }

        if (mana >= 10) {
            int danno = attacco + livello * 3;
            mana -= 10;
            System.out.println(nome + " lancia una palla di fuoco contro " + bersaglio.getNome() + "!");
            bersaglio.subisciDanno(danno);
            System.out.println("Mana rimanente: " + mana);
        } else {
            int danno = attacco;
            System.out.println(nome + " ha poco mana e usa un attacco magico debole su " + bersaglio.getNome() + "!");
            bersaglio.subisciDanno(danno);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " [mana=" + mana + "]";
    }
}
