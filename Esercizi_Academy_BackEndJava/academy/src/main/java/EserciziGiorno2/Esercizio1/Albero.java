package EserciziGiorno2.Esercizio1;

public class Albero {
    private String specie;
    private double altezza;
    private String coloreFoglie;

    public Albero(String specie, double altezza, String coloreFoglie) {
        this.specie = specie;
        this.altezza = altezza;
        this.coloreFoglie = coloreFoglie;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public String getColoreFoglie() {
        return coloreFoglie;
    }

    public void setColoreFoglie(String coloreFoglie) {
        this.coloreFoglie = coloreFoglie;
    }
}
