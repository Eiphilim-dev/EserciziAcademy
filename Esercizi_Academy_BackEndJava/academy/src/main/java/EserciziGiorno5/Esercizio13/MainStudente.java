package EserciziGiorno5.Esercizio13;

public class MainStudente {
    public static void main(String[] args) {
        Studente s1 = new Studente("Carlo", 18, 6.5);
        Studente s2 = new Studente("Davide", 27, 5.0);

        s1.stampaInfo();
        System.out.println(s1.isPromosso());
        s2.stampaInfo();
        System.out.println(s2.isPromosso());

    }
}
