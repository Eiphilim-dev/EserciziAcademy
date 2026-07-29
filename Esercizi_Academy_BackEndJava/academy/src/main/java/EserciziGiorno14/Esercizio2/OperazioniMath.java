package EserciziGiorno14.Esercizio2;

import java.util.ArrayList;
import java.util.List;

public abstract class OperazioniMath {
    private static List<Integer> listaMultipli = new ArrayList<>();
    private static List<Integer> listaNoMultipli = new ArrayList<>();

        public static void getMultipli(List<Integer> lista, int n) {
            for (Integer numeri : lista) {
                if(numeri % n == 0) {
                    listaMultipli.add(numeri);
                }
            }
            System.out.println("I multipli di " + n + " sono: " + listaMultipli);
        }

        public static void getListaNoMultipli(List<Integer> lista, int n) {
            for (Integer numeri : lista) {
                if(numeri % n != 0) {
                    listaNoMultipli.add(numeri);
                }
            }
            System.out.println("I numeri che non sono multipli di " + n + " sono: " + listaNoMultipli);
        }
    }
