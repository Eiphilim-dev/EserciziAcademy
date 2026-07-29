package EserciziGiorno12.Esercizio5;

public class TestGeometria {
    public static void main(String[] args) {
        Punto2D posRettangolo = new Punto2D(2, 3);
        Punto2D posQuadrato = new Punto2D(10, 15);

        Rettangolo r = new Rettangolo(4, 5, posRettangolo);
        r.draw();
        System.out.println("Area Rettangolo: " + r.area());

        System.out.println("---");

        Quadrato q = new Quadrato(3, posQuadrato);
        q.draw();
        System.out.println("Area Quadrato: " + q.area());
    }
}
