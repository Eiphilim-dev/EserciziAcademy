package EserciziGiorno6.Esercizio1_2;

public class EsempioCellulare {
    public static void main(String[] args) {
        Cellulare cell1 = new Cellulare("Nokia", "Alex", "334 5769837", 5.6);

        cell1.aggiungiInRubrica("346 8973527");
        cell1.aggiungiInRubrica("374 9387474");
        cell1.aggiungiInRubrica("346 8973527");
        cell1.aggiungiInRubrica("374 9387474");
        cell1.aggiungiInRubrica("346 8973527");
        cell1.aggiungiInRubrica("374 9387474");

        System.out.println("\n\n");
        cell1.stampaRubrica();

        cell1.chiama("28736428437");
        System.out.println("Il tuo credito residuo è: " + cell1.getCreditoResiduo());
        System.out.println("L'ultimo numero che hai chiamato è: " + cell1.getUltimoNumero());
    }
}
