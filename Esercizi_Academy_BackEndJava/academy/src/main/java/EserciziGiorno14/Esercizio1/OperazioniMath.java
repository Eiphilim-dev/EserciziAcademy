package EserciziGiorno14.Esercizio1;

import java.util.Collections;
import java.util.List;

public abstract class OperazioniMath {

    public static void getMax(List<Double> lista) {
        Double max = Collections.max(lista);
        System.out.println("Il numero massimo è: " + max);

    }

    public static void getAverage(List<Double> lista) {
         double media = 0.0;
         double somma = 0.0;
         
         for (Double numeri : lista) {
            somma += numeri;
            media = somma / lista.size();

         }
        System.out.println("La media dei numeri  è: " + media);
    }
}
