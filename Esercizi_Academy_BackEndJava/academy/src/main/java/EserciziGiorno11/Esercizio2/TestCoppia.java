package EserciziGiorno11.Esercizio2;

public class TestCoppia {
    public static void main(String[] args) {
        Coppia<String> coppiaParole = new Coppia<>();
        coppiaParole.salva("Ciao", "Mondo");

        System.out.println("Primo: " + coppiaParole.getUno());
        System.out.println("Secondo: " + coppiaParole.getDue());

        Coppia<Integer> coppiaNumeri = new Coppia<>();
        coppiaNumeri.salva(10, 20);
        
        System.out.println("Numero Uno: " + coppiaNumeri.getUno());
    }
}
