package EserciziGiorno8.Esercizio4;

public class Studente {
    private String nome;
    private String cognome;
    private double isee;
    private int annoCorso;

    public Studente(String nome, String cognome, double isee, int annoCorso) {
        this.nome = nome;
        this.cognome = cognome;
        this.isee = isee;
        this.annoCorso = annoCorso;
    }

    public double calcolaTasse(Studente s) {
        double tassaBase;
        if(s.getIsee() < 10000) {
            System.out.print("La tassa da pagare per ISEE sotto i 10000 euro è: ");
            tassaBase = 500;

        } else if(this.isee > 10000 && this.isee < 30000) {
            System.out.print("La tassa da pagare per ISEE sopra i 10000 euro ma minore di 30000 euro è: ");
            tassaBase = 700;

        } else {
            System.out.print("La tassa da pagare per ISEE sopra 30000 euro è: ");
            tassaBase = 1200;
        }

        double tassaFinale = tassaBase;

        
        if (s instanceof Triennale) {
            
            if (s.getAnnoCorso() > 3) {
                int anniFuoriCorso = s.getAnnoCorso() - 3;
                if (anniFuoriCorso > 3) {
                    anniFuoriCorso = 3;
                }
                tassaFinale += tassaBase * (0.10 * anniFuoriCorso); 
            }
        } 
        else if (s instanceof Magistrale) {
            
            if (s.getAnnoCorso() > 2) {
                int anniFuoriCorso = s.getAnnoCorso() - 2;
                if (anniFuoriCorso > 2) {
                    anniFuoriCorso = 2; 
                }
                tassaFinale += tassaBase * (0.15 * anniFuoriCorso);
            }
        }

        return tassaFinale;
    }

    public void stampaDatiStudente(Studente s) {
        System.out.println("\n=== Tasse per " + s.getNome() + "===");
            double tasse = calcolaTasse(s);
            String tipo = (s instanceof Triennale) ? "Triennale" : "Magistrale";
            
            System.out.println(s.getNome() + " " + s.getCognome() + " (" + tipo + ")" +
                               " - Anno: " + s.getAnnoCorso() + " - Tassa: " + tasse + " euro");
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public double getIsee() {
        return isee;
    }

    public int getAnnoCorso() {
        return annoCorso;
    }
}
