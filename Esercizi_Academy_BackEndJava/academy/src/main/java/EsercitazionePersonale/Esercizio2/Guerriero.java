package EsercitazionePersonale.Esercizio2;

public class Guerriero extends Personaggio {

    public Guerriero(String nome, int puntiVita, int livello, int attacco, int difesa) {
        super(nome, puntiVita, livello, attacco, difesa);
    }

    @Override
    public void attacca(Personaggio bersaglio) {
        if (!isVivo()) {
            System.out.println(nome + " è stato sconfitto e non può attaccare.");
            return;
        }

        int danno = attacco + livello * 2;
        System.out.println(nome + " colpisce " + bersaglio.getNome() + " con la spada!");
        bersaglio.subisciDanno(danno);
    }
}
