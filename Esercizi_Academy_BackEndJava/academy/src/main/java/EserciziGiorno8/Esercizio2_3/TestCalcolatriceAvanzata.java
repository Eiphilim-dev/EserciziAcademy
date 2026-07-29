package EserciziGiorno8.Esercizio2_3;

public class TestCalcolatriceAvanzata {
    public static void main(String[] args) {
        CalcolatriceAvanzata c1 = new CalcolatriceAvanzata();
        System.out.println(c1.somma(2,4));
        System.out.println(c1.somma(2,4,8));
        System.out.println(c1.somma(2,8,4,2));

        System.out.println(c1.sottrazione(2,4));
        System.out.println(c1.sottrazione(2,4,8));
        System.out.println(c1.sottrazione(2,8,4,2));

        System.out.println(c1.moltiplicazione(2,4));
        System.out.println(c1.moltiplicazione(2,4,8));
        System.out.println(c1.moltiplicazione(2,8,4,2));

        System.out.println(c1.divisione(2,4));
        System.out.println(c1.divisione(2,4,8));
        System.out.println(c1.divisione(3.0,4.0,5.0,6.0));
    }
}
