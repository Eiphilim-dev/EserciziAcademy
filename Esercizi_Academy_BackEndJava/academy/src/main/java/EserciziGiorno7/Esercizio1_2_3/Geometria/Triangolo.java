package EserciziGiorno7.Esercizio1_2_3.Geometria;

public class Triangolo extends FiguraGeometrica{
    private int lato1;
    private int lato2;
    private int lato3;

    
    public Triangolo(int lato1, int lato2, int lato3) {
        this.lato1 = lato1;
        this.lato2 = lato2;
        this.lato3 = lato3;

    }
//pisello
    @Override
    protected void calcoloArea() {
        double s = (lato1 + lato2 + lato3) / 2;
        double area = Math.sqrt(s * (s - lato1) * (s - lato2) * (s - lato3));

        System.out.println("Area del triangolo: " + area);

    }

    @Override
    protected void calcoloPerimetro() {
        System.out.println("Perimetro del triangolo: " + (lato1 + lato2 + lato3));

    }

    public int getLato1() {
        return lato1;
    }

    public void setLato1(int lato1) {
        this.lato1 = lato1;
    }

    public int getLato2() {
        return lato2;
    }

    public void setLato2(int lato2) {
        this.lato2 = lato2;
    }

    public int getLato3() {
        return lato3;
    }

    public void setLato3(int lato3) {
        this.lato3 = lato3;
    } 
}
