package EserciziGiorno11.Esercizio3;

public class TestCoppiaMista {
    public static void main(String[] args) {
        CoppiaMista<String, Integer> utente = new CoppiaMista<>();
        utente.salva("ID_Utente", 98765);

        System.out.println("Chiave: " + utente.getUno());
        System.out.println("Valore: " + utente.getDue());
    }
}
