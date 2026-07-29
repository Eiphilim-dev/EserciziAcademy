package EserciziGiorno10.Esercizio2;

import java.util.ArrayList;

public class Anime {
    private String titolo;
    private int numEpisodi;
    private String categoria;
    private String lunghezzaEpisodio;
    private static ArrayList<String> categorieValide;


    public Anime() {
        
    }

    public Anime(String titolo, String categoria) {
        this.titolo = titolo;

        if(categorieValide.contains(categoria)){
        this.categoria = categoria;
        } else {
            System.out.println("Categoria " + categoria + " non disponibile");
        }
        System.out.println("Anime creato: " + titolo);
    }

    public Anime(String titolo, String categoria, int numEpisodi, String lunghezzaEpisodio) {
        this.titolo = titolo;

        if(categorieValide.contains(categoria)){
        this.categoria = categoria;
        } else {
            System.out.println("Categoria " + categoria + " non disponibile");
        }
        this.numEpisodi = numEpisodi;
        this.lunghezzaEpisodio = lunghezzaEpisodio;
        System.out.println("Anime creato: " + titolo);
    }

    static {
        categorieValide = new ArrayList<>();
        categorieValide.add("Shounen");
        categorieValide.add("Azione");
        categorieValide.add("Avventura");
        categorieValide.add("Drama");
        System.out.println(" (Costruttore) Categorie di default applicate.");
    }

    {
        this.numEpisodi = 0;                  
        this.lunghezzaEpisodio = "24 minuti"; 
        this.categoria = "Non specificata";  
        System.out.println("(Istanza) Valori di default applicati.");
    }


    public void mostraDati() {
        System.out.println("Anime: " + titolo + " | Categoria: " + categoria + 
                           " | Episodi: " + numEpisodi + " | Durata: " + lunghezzaEpisodio);
    }

}
