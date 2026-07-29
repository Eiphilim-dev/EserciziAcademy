package EserciziGiorno8.Esercizio2_3;

public class CalcolatriceAvanzata {
    
    public double somma(double a, double b) {
        System.out.print("Somma di due numeri: " + a + " + " + b + " = ");
        return a + b;
    }
     
    public double somma(double a, double b, double c) {
        System.out.print("Somma di tre numeri: " + a + " + " + b + " + " + c + " = ");
        return a + b + c;
    }

    public double somma(double... array) {
        double risultato = 0;
        for (double d : array) {
            risultato += d;
        }
        System.out.print("Somma di un array di numeri: ");
        return risultato;
    }


    public double sottrazione(double a, double b) {
        System.out.print("Sottrazione di due numeri: " + a + " - " + b + " = ");
        return a - b;
    }
     
    public double sottrazione(double a, double b, double c) {
        System.out.print("Sottrazione di tre numeri: " + a + " - " + b + " - " + c + " = ");
        return a - b - c;
    }

    public double sottrazione(double... array) {
        double risultato = array[0];
        for (int i = 1; i < array.length; i++) {
            risultato -= array[i];

        }

        System.out.print("Sottrazione di un array di numeri: ");
        return risultato;
    }


    public double moltiplicazione(double a, double b) {
        System.out.print("Prodotto di due numeri: " + a + " * " + b + " = ");
        return a * b;
    }
     
    public double moltiplicazione(double a, double b, double c) {
        System.out.print("Prodotto di tre numeri: " + a + " * " + b + " * " + c + " = ");
        return a * b * c;
    }

    public double moltiplicazione(double... array) {
        double risultato = 1;
        for (double d : array) {
            risultato *= d;
        }
        System.out.print("Prodotto di un array di numeri: ");
        return risultato;
    }


    public double divisione(double a, double b) {
        System.out.print("Divisione di due numeri: " + a + " : " + b + " = ");
        return a / b;
    }
     
    public double divisione(double a, double b, double c) {
        System.out.print("Divisione di tre numeri: " + a + " : " + b + " : " + c + " = ");
        return a / b / c;
    }

    public double divisione(double... array) {
        if (array == null || array.length == 0) {
        throw new IllegalArgumentException("L'array non può essere vuoto o nullo!");

    }

        double risultato = array[0];
        for (int i = 1; i < array.length; i++) {
        if (array[i] == 0) {
            System.out.print("Errore (Divisione per zero rilevata): ");
            return Double.NaN;
            }
            
            risultato /= array[i];
        }      
        
        System.out.print("Divisione di un array di numeri: ");
        return risultato;

    }
}
