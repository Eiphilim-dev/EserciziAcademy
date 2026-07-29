package EserciziGiorno12.Esercizio4;

import java.util.Arrays;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        List<String> nomi = Arrays.asList("Java", "Python", "C++", "JavaScript");

        System.out.println("Stampa della lista con Lambda Expression:");
        nomi.forEach(nome -> System.out.println(nome));
    }
}
