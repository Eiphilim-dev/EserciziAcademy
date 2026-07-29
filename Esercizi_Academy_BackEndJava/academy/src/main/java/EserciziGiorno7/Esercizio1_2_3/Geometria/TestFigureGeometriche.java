package EserciziGiorno7.Esercizio1_2_3.Geometria;

public class TestFigureGeometriche {
    public static void main(String[] args) {
        FiguraGeometrica quadrato = new Quadrato(5);
        FiguraGeometrica rettangolo = new Rettangolo(4, 6);
        FiguraGeometrica triangolo = new Triangolo(7, 5, 8);

        quadrato.calcoloArea();
        quadrato.calcoloPerimetro();

        rettangolo.calcoloArea();
        rettangolo.calcoloPerimetro();

        triangolo.calcoloArea();
        triangolo.calcoloPerimetro();
    }
}
