package EserciziGiorno5.Esercizio14_15;

public class MainConto {
    public static void main(String[] args) {
        ContoCorrente c1 = new ContoCorrente("A4gr3A", "Alex Ferdinando", 2050);
        ContoCorrente c2 = new ContoCorrente("foein4W", "Mario Rossi", 20004);
        ContoCorrente c3 = new ContoCorrente("aodwiI2x", "Francesco Gigio", 4500);

        c1.stampaConto();
        c1.deposita(300);
        c1.preleva(200);

        c2.stampaConto();
        c2.deposita(500);
        c2.preleva(20000);

        c3.stampaConto();
        c3.preleva(348);
        c3.deposita(0);
    }
}
