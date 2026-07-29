package EserciziGiorno9.Esercizio2;
@SuppressWarnings("all")
public class ExceptionInt {
    public static void main(String[] args) {
        try{
        int[] t = null; 
        t[0] = 7;

        }catch(NullPointerException e) {
            System.out.println("Non può essere Null:" + e.getMessage());

        }
    }
}
