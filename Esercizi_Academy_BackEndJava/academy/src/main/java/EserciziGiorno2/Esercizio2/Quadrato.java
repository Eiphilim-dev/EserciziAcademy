package EserciziGiorno2.Esercizio2;

public class Quadrato {
    private int lato;


    public Quadrato() {
    }

    public Quadrato(int lato) {
        this.lato = lato;
    }

    public void getPerimetro() {
        int perimetro = getLato() * 4;
        System.out.println("Il perimetro del Quadrato è: " + perimetro + "\n");
    }

    public void getArea() {
        int area = getLato() * getLato();
        System.out.println("L'area del Quadrato è: " + area);
    }

    public int getLato() {
        return lato;
    }
}
