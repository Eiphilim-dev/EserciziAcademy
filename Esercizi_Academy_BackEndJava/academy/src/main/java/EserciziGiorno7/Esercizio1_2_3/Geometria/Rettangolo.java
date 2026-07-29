package EserciziGiorno7.Esercizio1_2_3.Geometria;

public class Rettangolo extends FiguraGeometrica{
    private int base;
    private int altezza;

    public Rettangolo(int base, int altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    @Override
    protected void calcoloArea() {
        int area = base * altezza;
        System.out.println("Area del rettangolo: " + area);

    }

    @Override
    protected void calcoloPerimetro() {
        int perimetro = (base + altezza) * 2;
        System.out.println("Perimetro del rettangolo: " + perimetro);

    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }
}
