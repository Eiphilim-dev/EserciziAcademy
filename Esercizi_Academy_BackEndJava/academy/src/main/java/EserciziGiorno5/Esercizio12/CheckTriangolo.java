package EserciziGiorno5.Esercizio12;

public class CheckTriangolo {
    public static void main(String[] args) {
        double lato1 = 7;
        double lato2 = 8;
        double lato3 = 8;

        if ((lato1 == lato2) && (lato2 == lato3)) {
            System.out.println("Il triangolo è equilatero");

        } else if((lato1 == lato2) || (lato2 == lato3) || (lato1 == lato3)) {
            System.out.println("Il triangolo è isoscele");

        } else {
            System.out.println("Il triangolo è scaleno");

        }
    } 
}
