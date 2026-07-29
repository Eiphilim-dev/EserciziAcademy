package EserciziGiorno10.Esercizio3_4;

public class MacchinettaCaffe {
    private int numCialdeInserite = 0;
    private static final int NUM_MAX_CIALDE = 9;
    private int caffeFattiTot = 0;
    private boolean inserimento = false;
    private int caffeDallUltimoSvuotamento = 0;


    public MacchinettaCaffe() {
        
    }


    public boolean inserisciCialda() { 
        if (numCialdeInserite >= NUM_MAX_CIALDE) {
            System.out.println("Impossibile inserire la cialda: il cassetto delle cialde usate è pieno! Svuotalo.");
            return false;
        }
        
        if (inserimento) {
            System.out.println("C'è già una cialda inserita pronta per l'uso!");
            return false;
        }

        System.out.println("Hai inserito con successo 1 cialda.");
        inserimento = true;
        return true;
    }

    public void faiCaffe() {
        if (inserimento) {
            caffeFattiTot++;
            caffeDallUltimoSvuotamento++;
            numCialdeInserite++; 

            System.out.println("Sto facendo il caffè aspetta un momento...");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.println("Caffè fatto! ☕");
            inserimento = false; 

        } else {
            System.out.println("Errore: Non hai inserito la cialda nel vano!");
        }
    }

    public void svuotaCassetto() {
        System.out.println("Sto svuotando il cassetto dalle " + numCialdeInserite + " cialde usate.");
        numCialdeInserite = 0;
        caffeDallUltimoSvuotamento = 0; 
    }

    public void mostraTotCaffeFatti() {
        System.out.println("In totale, da quando la macchina è accesa, hai realizzato: " + caffeFattiTot + " caffè.");
    }

    public void mostraTotCaffeUltimoSvuot() {
        System.out.println("Dall'ultimo svuotamento del cassetto hai realizzato: " + caffeDallUltimoSvuotamento + " caffè.");
    }

}
