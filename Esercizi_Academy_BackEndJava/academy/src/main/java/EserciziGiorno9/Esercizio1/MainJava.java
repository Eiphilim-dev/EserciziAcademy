package EserciziGiorno9.Esercizio1;

public class MainJava {
    public static void main(String[] args) {
        int num = 10;
        Object obj = (Object) num;
        try {
        System.out.println((String)obj);
        
        }catch(ClassCastException e) {
            System.out.println("Errore di cast: " + e.getMessage());

        }
    }
}
