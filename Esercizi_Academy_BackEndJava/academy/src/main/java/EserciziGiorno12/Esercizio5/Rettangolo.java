package EserciziGiorno12.Esercizio5;

public class Rettangolo implements Shape, TwoDShape{
    private double base;
    private double altezza;
    private Punto2D posizione;

    public Rettangolo(double base, double altezza, Punto2D posizione) {
        this.base = base;
        this.altezza = altezza;
        this.posizione = posizione;
    }

    public double getBase() { return base; }
    public double getAltezza() { return altezza; }
    public Punto2D getPosizione() { return posizione; }

    public double area() { return base * altezza; }
    public double perimetro() { return 2 * (base + altezza); }
    public void draw() { System.out.println("Disegno Rettangolo in (" + posizione.getX() + ", " + posizione.getY() + ")"); }
}
