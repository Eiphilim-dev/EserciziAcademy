package EserciziGiorno10.Esercizio11;

public class MainCiclo {
    public static void main(String[] args) {
        for(int i = 0; i <= 100; i++) {
            if(i == 10 || i == 30 || i == 50) {
                continue;
            }
            System.out.println(i);
        }
    }
}
