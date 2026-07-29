package EserciziGiorno3;

public class MainEsercizi {
    public static void main(String[] args) {
        //Esercizio 1
        System.out.println("//Esercizio1");
        int lato1 = 10;
        int lato2 = 10;
        int lato3 = 10;
        int lato4 = 10;

        boolean latiUguali = (lato1 == lato2)
                && (lato2 == lato3)
                && (lato3 == lato4);

        if (latiUguali) {
            System.out.println("\nLa figura geometrica in questione è un quadrato");

        } else {
            System.out.println("Non è un quadrato");

        }

        System.out.println("---------------------------------------------------");

        //Esercizio2
        System.out.println("//Esercizio2\n");
        char carattere = 'f';

        boolean charOcons = "aeiou".contains(String.valueOf(carattere).toLowerCase());

        if (charOcons) {
            System.out.println("E' una vocale");

        } else {
            System.out.println("E' una consonante");

        }

        System.out.println("---------------------------------------------------");

        //Esercizio3
        System.out.println("//Esercizio3\n");
        int i = 1;
        while (i <= 10) {
            System.out.print(i + " ");
            i++;
        }

        System.out.println("\n- - - - -");

        for (i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }

        System.out.println("\n---------------------------------------------------");

        //Esercizio4
        System.out.println("//Esercizio4\n");
        i = 10;
        while (i >= 0) {
            System.out.print(i + " ");
            i--;
        }

        System.out.println("\n- - - - -");

        for (i = 10; i >= 0; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n---------------------------------------------------");

        //Esercizio5
        System.out.println("//Esercizio5\n");
        i = 0;
        while (i >= -10) {
            if (i % 2 == 0) {
                System.out.print(i + " ");

            }
            i--;
        }

        System.out.println("\n- - - - -");

        for (i = 0; i >= -10; i--) {
            if (i % 2 == 0) {
                System.out.print(i + " ");

            }
        }

        System.out.println("\n---------------------------------------------------");

        //Esercizio6
        System.out.println("//Esercizio6\n");
        i = -1;
        while (i <= 20) {
            if (i % 2 != 0) {
                System.out.print(i + " ");

            }
            i++;
        }

        System.out.println("\n- - - - -");

        for (i = -1; i <= 20; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");

            }
        }

        System.out.println("\n---------------------------------------------------");

        //Esercizio7
        System.out.println("//Esercizio7\n");
        int somma = 0;
        for (i = 1; i <= 10; i++) {
            somma += i;

        }
        ;

        System.out.println("La somma è:" + somma);

        System.out.println("\n- - - - -");

        while (i <= 10) {
            somma += i;
            i++;
        }
        System.out.println("La somma è:" + somma);

        System.out.println("\n---------------------------------------------------");

        //Esercizio8
        int numero = 7;
        System.out.println("Tabellina del " + numero);

        for (i = 1; i <= 10; i++) {
            int risultato = numero * i;
            System.out.println(numero + " x " + i + " = " + risultato);
        }
    }
}
