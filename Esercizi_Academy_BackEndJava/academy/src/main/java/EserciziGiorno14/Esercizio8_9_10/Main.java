package EserciziGiorno14.Esercizio8_9_10;

public class Main {

    public static void stampaResocontoSistemiOperativi(GestioneInventario gestione) {
        int windows = 0;
        int macos = 0;
        int linux = 0;
        int android = 0;
        int ios = 0;

        Dispositivo[] inventario = gestione.getInventario();

        for (int i = 0; i < gestione.getNumeroDispositivi(); i++) {
            switch (inventario[i].getSistemaOperativo()) {
                case WINDOWS:
                    windows++;
                    break;
                case MACOS:
                    macos++;
                    break;
                case LINUX:
                    linux++;
                    break;
                case ANDROID:
                    android++;
                    break;
                case IOS:
                    ios++;
                    break;
            }
        }

        System.out.println("\n--- RESOCONTO SISTEMI OPERATIVI ---");
        System.out.println("WINDOWS: " + windows);
        System.out.println("MACOS: " + macos);
        System.out.println("LINUX: " + linux);
        System.out.println("ANDROID: " + android);
        System.out.println("IOS: " + ios);
    }

    public static void eseguiFunzioneSpecifica(Dispositivo dispositivo) {
        if (dispositivo instanceof Computer) {
            Computer computer = (Computer) dispositivo;
            computer.inserisciPeriferica("Mouse USB");
        } else if (dispositivo instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) dispositivo;
            smartphone.mandaMessaggio("Giulia", "Ciao, messaggio di test!");
        } else {
            System.out.println("Tipo di dispositivo non riconosciuto.");
        }
    }

    public static void main(String[] args) {
        GestioneInventario gestione = new GestioneInventario(10);

        Dispositivo d1 = new Computer("Dell", "Inspiron", 899.99, SistemaOperativo.WINDOWS);
        Dispositivo d2 = new Smartphone("Samsung", "Galaxy S24", 999.99, SistemaOperativo.ANDROID);
        Dispositivo d3 = new Computer("Apple", "MacBook Air", 1299.99, SistemaOperativo.MACOS);
        Dispositivo d4 = new Smartphone("Apple", "iPhone 15", 1199.99, SistemaOperativo.IOS);
        Dispositivo d5 = new Computer("Lenovo", "ThinkPad", 1099.99, SistemaOperativo.LINUX);

        gestione.aggiungiDispositivo(d1);
        gestione.aggiungiDispositivo(d2);
        gestione.aggiungiDispositivo(d3);
        gestione.aggiungiDispositivo(d4);
        gestione.aggiungiDispositivo(d5);

        System.out.println("\n--- INVENTARIO COMPLETO ---");
        gestione.stampaInventario();

        System.out.println("\n--- TEST POLIMORFISMO ---");
        eseguiFunzioneSpecifica(d1);
        eseguiFunzioneSpecifica(d2);

        stampaResocontoSistemiOperativi(gestione);

        System.out.println("\n--- RIMOZIONE DISPOSITIVO ---");
        gestione.rimuoviDispositivo("Galaxy S24");

        System.out.println("\n--- INVENTARIO AGGIORNATO ---");
        gestione.stampaInventario();
    }
}