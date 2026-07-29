package EserciziGiorno7.Esercizio1_2_3.Geometria;

public class Quadrato extends FiguraGeometrica{
    private int lato;

    public Quadrato(int lato) {
        this.lato = lato;
    }

    @Override
    protected void calcoloArea() {
        int area = lato * lato;
        System.out.println("Area del quadrato: " + area);

    }

    @Override
    protected void calcoloPerimetro() {
        int perimetro = lato * 4;
        System.out.println("Perimetro del quadrato: " + perimetro);

    }

    public int getLato() {
        return lato;
    }

    public void setLato(int lato) {
        this.lato = lato;
    }
}
