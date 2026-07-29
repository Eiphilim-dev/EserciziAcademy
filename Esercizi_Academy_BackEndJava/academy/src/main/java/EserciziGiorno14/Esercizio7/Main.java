package EserciziGiorno14.Esercizio7;

public class Main {
    public static void main(String[] args) {
        try {
            Box box1 = new Box(10, 10, 30);
            Box box2 = new Box(10, 20, 30);

            System.out.println("Box 1: " + box1);
            System.out.println("Box 2: " + box2);

            if (box1.equals(box2)) {
                System.out.println("Le due scatole sono uguali.");
            } else {
                System.out.println("Le due scatole sono diverse.");
            }

            if (box1.isContenuto(box2)) {
                System.out.println("Box2 può essere contenuto in Box1.");
            } else {
                System.out.println("Box2 non può essere contenuto in Box1.");
            }

            if (box2.isContenuto(box1)) {
                System.out.println("Box1 può essere contenuto in Box2.");
            } else {
                System.out.println("Box1 non può essere contenuto in Box2.");
            }

        } catch (UndiscoveredDimensionException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
