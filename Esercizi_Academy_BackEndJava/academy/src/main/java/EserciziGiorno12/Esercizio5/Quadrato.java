package EserciziGiorno12.Esercizio5;

public class Quadrato extends Rettangolo{
    public Quadrato(double lato, Punto2D posizione) {
        super(lato, lato, posizione);
    }

        public double getLato() { return getBase(); }

    @Override
    public void draw() { System.out.println("Disegno Quadrato in (" + getPosizione().getX() + ", " + getPosizione().getY() + ")");      
    }
}

