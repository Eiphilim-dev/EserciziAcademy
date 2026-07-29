package EserciziGiorno5.Esercizio6;

import java.util.Scanner;

public class Cerchio {
    static final double PI_GRECO = Math.PI;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Scegli il valore del raggio del cerchio: ");
        double raggio = scanner.nextDouble();

        getCirconferenzaCerchio(raggio);
        System.out.println("--------------------");
        getAreaCerchio(raggio);

        scanner.close();
    }

    public static void getCirconferenzaCerchio(double raggio) {
        double circonferenza = 2 * PI_GRECO * raggio;
        System.out.println("La circonferenza del cerchio è: " + circonferenza);
    }

    public static void getAreaCerchio(double raggio) {
        double area = PI_GRECO * (raggio * raggio);
        System.out.println("L'area del cerchio è: " + area);
    }
}
