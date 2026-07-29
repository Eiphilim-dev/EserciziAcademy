package EserciziGiorno2.Esercizio3;

public class ViaggioMain {
    public static void main(String[] args) {
        Viaggio viaggio1 = new Viaggio("Roma", 10, 100.0, 2);
        Viaggio viaggio2 = new Viaggio("Napoli", 20, 150.0, 3);

        System.out.println(viaggio1.getDescrizione());
        System.out.println(viaggio1.prenotaPosti(4));

        System.out.println();

        System.out.println(viaggio2.getDescrizione());
        System.out.println(viaggio2.prenotaPosti(1));
    }
}
