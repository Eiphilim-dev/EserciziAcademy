package EserciziGiorno9.Esercizio5;

public class MainSottrazione {
    public static void main(String[] args) {
        int[] array = {2,4,6,7};
        int risultato = array[0];

        for (int i = 1; i < array.length; i++) {
            risultato -= array[i];

            if(risultato < 0) {
                throw new SottrazioneNegativaException("Il risultato non può essere sotto lo 0");
                
            }
            

        }

        System.out.print("Sottrazione di un array di numeri: " + risultato);
    }
}
