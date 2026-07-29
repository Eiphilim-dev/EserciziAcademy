package EserciziGiorno9.Esercizio4;

public class ArrayInt {
    public static void main(String[] args) {
        try{
        int[] arr = {2,3,4};

        for(int i = 0; i < 5; i++) {
            System.out.println(arr[i]);
            }

        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("L'array è troppo piccolo: " + e.getMessage());

        }
    }
}
