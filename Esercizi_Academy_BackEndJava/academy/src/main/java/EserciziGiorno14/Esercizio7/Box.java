package EserciziGiorno14.Esercizio7;

import java.util.Objects;

public class Box {
    private double altezza;
    private double lunghezza;
    private double profondita;

    public Box(double altezza, double lunghezza, double profondita) throws UndiscoveredDimensionException {
        if (altezza < 0 || lunghezza < 0 || profondita < 0) {
            throw new UndiscoveredDimensionException("Le dimensioni non possono essere minori di 0");
        }
        this.altezza = altezza;
        this.lunghezza = lunghezza;
        this.profondita = profondita;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) throws UndiscoveredDimensionException {
        if (altezza < 0) {
            throw new UndiscoveredDimensionException("L'altezza non può essere minore di 0");
        }
        this.altezza = altezza;
    }

    public double getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza(double lunghezza) throws UndiscoveredDimensionException {
        if (lunghezza < 0) {
            throw new UndiscoveredDimensionException("La lunghezza non può essere minore di 0");
        }
        this.lunghezza = lunghezza;
    }

    public double getProfondita() {
        return profondita;
    }

    public void setProfondita(double profondita) throws UndiscoveredDimensionException {
        if (profondita < 0) {
            throw new UndiscoveredDimensionException("La profondità non può essere minore di 0");
        }
        this.profondita = profondita;
    }

    public boolean isContenuto(Box altro) {
        return altro.altezza <= this.altezza
                && altro.lunghezza <= this.lunghezza
                && altro.profondita <= this.profondita;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Box other = (Box) obj;
        return Double.compare(altezza, other.altezza) == 0
                && Double.compare(lunghezza, other.lunghezza) == 0
                && Double.compare(profondita, other.profondita) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(altezza, lunghezza, profondita);
    }

    @Override
    public String toString() {
        return "Box{" +
                "altezza=" + altezza +
                ", lunghezza=" + lunghezza +
                ", profondita=" + profondita +
                '}';
    }
}
