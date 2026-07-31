public abstract class Videogioco {
    private String nome;
    private double prezzo;
    private int pegi;

    public Videogioco(String nome, double prezzo, int pegi) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.pegi = pegi;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPrezzo() { return prezzo; }
    public void setPrezzo(double prezzo) { this.prezzo = prezzo; }

    public int getPegi() { return pegi; }
    public void setPegi(int pegi) { this.pegi = pegi; }

    public abstract void gioca();

    @Override
    public String toString() {
        return "Nome: " + nome + ", Prezzo: " + prezzo + ", PEGI: " + pegi;
    }
}