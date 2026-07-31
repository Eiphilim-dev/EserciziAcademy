package main;

import dao.GiocoDaTavoloImpl;
import entity.GiocoDaTavolo;
import entity.Partecipante;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    static void main(String[] args) {
        Partecipante p1 = new Partecipante("Mario", "Rossi", 30);
        Partecipante p2 = new Partecipante("Laura", "Bianchi", 25);
        Partecipante p3 = new Partecipante("Giuseppe", "Verdi", 42);

        GiocoDaTavolo g1 = new GiocoDaTavolo("Catan","Giochi Uniti",
                3, 4, 10);

        GiocoDaTavolo g2 = new GiocoDaTavolo("Tavolin","Libellud", 3, 8, 8);

        GiocoDaTavolo g3 = new GiocoDaTavolo("Exploding Kittens","Asmodee",
                2, 5, 7);

        GiocoDaTavoloImpl giocoDao = new GiocoDaTavoloImpl();

        System.out.println("=== TEST SAVE ===");
        GiocoDaTavolo gioco1 = new GiocoDaTavolo("Monopoly", "Hasbro",
                3, 4, 10);

        giocoDao.save(gioco1);
        System.out.println("Gioco salvato: " + gioco1.getNome());


        System.out.println("\n=== TEST SAVE ALL ===");
        List<GiocoDaTavolo> listaGiochi = new ArrayList<>();
        listaGiochi.add(g1);
        listaGiochi.add(g2);
        listaGiochi.add(g3);

        giocoDao.saveAll(listaGiochi);
        System.out.println("Salvati con successo " + listaGiochi.size() + " giochi in blocco.");


        System.out.println("\n=== 3. TEST FIND BY IDENTIFICATION (Ricerca per ID/Nome) ===");

        String nomeCercato = "Dixit";
        GiocoDaTavolo giocoTrovato = giocoDao.findByIdentification(nomeCercato);

        if (giocoTrovato != null) {
            System.out.println("Gioco trovato nel DB: " + giocoTrovato.getNome()
                    + " (Età minima: " + giocoTrovato.getEtaMinima() + ")");
        } else {
            System.out.println("Nessun gioco trovato con nome: " + nomeCercato);
        }


        System.out.println("\n=== 4. TEST FIND ALL (Lista di tutti i giochi) ===");

        List<GiocoDaTavolo> tuttiIGiochi = giocoDao.findAll();
        System.out.println("Totale giochi nel database: " + tuttiIGiochi.size());
        for (GiocoDaTavolo g : tuttiIGiochi) {
            System.out.println(" - " + g.getNome() + " [Età Minima: " + g.getEtaMinima() + "]");
        }


        System.out.println("\n=== 5. TEST IS GIOCO ADATTO PER ETA ===");

        String nomeGiocoDaTestare = "Catan";
        int etaGiocatoreMinorenne = 8;
        int etaGiocatoreAdulto = 12;

        boolean puoGiocare8Anni = giocoDao.isGiocoAdattoPerEta(nomeGiocoDaTestare, etaGiocatoreMinorenne);
        if (puoGiocare8Anni) {
            System.out.println("Un bambino di " + etaGiocatoreMinorenne + " anni PUÒ giocare a " + nomeGiocoDaTestare);
        } else {
            System.out.println("Un bambino di " + etaGiocatoreMinorenne + " anni NON PUÒ giocare a " + nomeGiocoDaTestare + " (è troppo giovane!)");
        }

        boolean puoGiocare12Anni = giocoDao.isGiocoAdattoPerEta(nomeGiocoDaTestare, etaGiocatoreAdulto);
        if (puoGiocare12Anni) {
            System.out.println("Un ragazzo di " + etaGiocatoreAdulto + " anni PUÒ giocare a " + nomeGiocoDaTestare);
        } else {
            System.out.println("Un ragazzo di " + etaGiocatoreAdulto + " anni NON PUÒ giocare a " + nomeGiocoDaTestare);
        }
    }
}
