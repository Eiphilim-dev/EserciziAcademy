package EserciziGiorno8.Esercizio4;

public class MainStudente {
    public static void main(String[] args) {
        Studente[] segreteria = new Studente[5];
        segreteria[0] = new Triennale("Mario", "Rossi", 8000, 2);
        segreteria[1] = new Triennale("Luca", "Bianchi", 15000, 4);
        segreteria[2] = new Triennale("Giulia", "Verdi", 25000, 3);
        segreteria[3] = new Magistrale("Francesca", "Neri", 12000, 1);
        segreteria[4] = new Magistrale("Alessandro", "Gialli", 35000, 3);
        
        for(Studente s : segreteria ) {
            s.stampaDatiStudente(s);
        }
    }
}
