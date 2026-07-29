package EserciziGiorno10.Esercizio5;

import java.util.ArrayList;
import java.util.Random;

public class Gara {
    private String nomeCircuito;
    private Pilota vincitore;
    private ArrayList<Pilota> grigliaPartenza = new ArrayList<Pilota>();

    
    public Gara(String nomeCircuito) {
        this.nomeCircuito = nomeCircuito;
    }



    public void creaGrigliaDiPartenza(ArrayList<Pilota> piloti) {
        grigliaPartenza.addAll(piloti);
        System.out.println("Griglia creata per il circuito " + nomeCircuito + ". Piloti pronti: " + grigliaPartenza.size());

    }

    public Pilota corriGara() {
        Random generatore = new Random();

        int indiceVincente = generatore.nextInt(grigliaPartenza.size());
        this.vincitore = grigliaPartenza.get(indiceVincente);

        System.out.println("--- La gara è terminata! ---");
        System.out.println("Il vincitore sul circuito di: " + this.nomeCircuito + " è: " + this.vincitore.getNome());
        
        return this.vincitore;

    }

}
