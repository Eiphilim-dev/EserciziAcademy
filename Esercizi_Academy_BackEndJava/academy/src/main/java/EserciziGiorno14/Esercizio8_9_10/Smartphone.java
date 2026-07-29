package EserciziGiorno14.Esercizio8_9_10;

public class Smartphone extends Dispositivo {
    public Smartphone(String marca, String modello, double prezzo, SistemaOperativo sistemaOperativo) {
        super(marca, modello, prezzo, sistemaOperativo);
    }

    public void mandaMessaggio(String destinatario, String messaggio) {
        System.out.println("Messaggio inviato a " + destinatario + ": " + messaggio);
    }

    @Override
    public void stampaDettagli() {
        super.stampaDettagli();
        System.out.println("Funzione smartphone attiva.");
    }
}