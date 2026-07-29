package EserciziGiorno2.Esercizio1;

public class Cane extends Animale {
    private final int N_ZAMPE = 4;

    public Cane() {
    }

    public Cane(String nome, String razza, int eta) {
        super(nome, razza, eta);
    }

    public void abbaia() {
        System.out.println(getNome() + " sta abbaiando.");
    }

    @Override
    public void cammina() {
        super.cammina();
        System.out.println("Ho " + getN_ZAMPE() + " zampe.");
    }

    @Override
    public void salta() {

        super.salta();
    }

    public int getN_ZAMPE() {
        return N_ZAMPE;
    }
}
