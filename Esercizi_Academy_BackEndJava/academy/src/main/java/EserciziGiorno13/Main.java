package EserciziGiorno13;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Libro l1 = new Libro("Il Signore degli Anelli", 29.99, "J.R.R. Tolkien");
        Libro l2 = new Libro("1984", 19.99, "George Orwell");

        try {
            Serializer.serialize("libri.ser", l1);
            Serializer.serialize("libri2.ser", l2);

            System.out.println("Oggetti serializzati con successo!");

            
            Libro risultato1 = (Libro) Deserializer.deserialize("libri.ser");
            System.out.println("Oggetto deserializzato: " + risultato1.getTitolo() + ", " + risultato1.getPrezzo() + ", " + risultato1.getAutore());

            Libro risultato2 = (Libro) Deserializer.deserialize("libri2.ser");
            System.out.println("Oggetto deserializzato: " + risultato2.getTitolo() + ", " + risultato2.getPrezzo() + ", " + risultato2.getAutore());
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
