package EserciziGiorno7.Esercizio4_5;

public class MainGuerra {
    public static void main(String[] args) {
        Soldato fante = new Fante("Marco", 10, 100);
        Soldato cavaliere = new Cavaliere("Davide", 20, 150, "Fulmine");

        System.out.println(fante);
        fante.gridoDiBattaglia();
        fante.combatti();
        fante.riposa();
        fante.avanza();

        System.out.println();

        System.out.println(cavaliere);
        cavaliere.gridoDiBattaglia();
        cavaliere.combatti();
        cavaliere.riposa();
        cavaliere.avanza();
    }
}
