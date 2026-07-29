package EserciziGiorno9.Esercizio3;

@SuppressWarnings("all")
public class ExceptionString {
    public static void main(String[] args) {
        try{
            String s = null;
            int l = s.length();

        }catch(NullPointerException e) {
            System.out.println("Non può essere null: " + e.getMessage());
        } 
    }
}
