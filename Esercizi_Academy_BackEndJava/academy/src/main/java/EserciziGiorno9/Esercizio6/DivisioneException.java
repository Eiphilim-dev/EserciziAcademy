package EserciziGiorno9.Esercizio6;

public class DivisioneException {
    public static void main(String[] args) {

        int[] array = {3,0,5,6};
        int risultato = 100;

        for (int i = 1; i < array.length; i++) {
            
        if (array[i] == 0 || (risultato /= array[i]) == 0) {
                throw new NoZeroException("Non può essere 0");

            } else if((risultato /= array[i]) == 0) {
                throw new NoZeroException("Il risultato non può essere 0");
                
            }

            risultato /= array[i];
        }      
        
        System.out.print("Divisione di un array di numeri: " + risultato);
    }
}
