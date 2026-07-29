package EserciziGiorno2.Esercizio1;

public class Animale {
    private String nome;
    private String razza;
    private int eta;

    public Animale() {
    }

    public Animale(String nome, String razza, int eta) {
        this.nome = nome;
        this.razza = razza;
        this.eta = eta;
    }

    public void salta() {
        System.out.println(getNome() + " sta saltando");
    }

    public void cammina() {
        System.out.println(getNome() + " sta camminando");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazza() {
        return razza;
    }

    public void setRazza(String razza) {
        this.razza = razza;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
}
