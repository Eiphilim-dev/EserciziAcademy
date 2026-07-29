package EserciziGiorno11.Esercizio1;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- TEST OPPOSTI ---");
        
        System.out.println("NORD è opposto a SUD? -> " + Cardinal.NORD.isOpposite(Cardinal.SUD)); 
        System.out.println("NORD è opposto a EST? -> " + Cardinal.NORD.isOpposite(Cardinal.EST)); 

        System.out.println("\n--- TEST INTERMEDIO ---");
        Cardinal m1 = Cardinal.mix(Cardinal.NORD, Cardinal.EST);
        System.out.println("Intermedio tra NORD ed EST: " + m1); 

        Cardinal m2 = Cardinal.mix(Cardinal.NORD_OVEST, Cardinal.NORD_EST);
        System.out.println("Intermedio tra NORD_OVEST e NORD_EST: " + m2); 
    }
}
