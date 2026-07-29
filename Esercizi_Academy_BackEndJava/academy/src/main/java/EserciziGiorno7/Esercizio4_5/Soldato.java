package EserciziGiorno7.Esercizio4_5;

public abstract class Soldato {
    private String nome;
    private int forza;
    private int salute;

    public Soldato(String nome, int forza, int salute) {
        this.nome = nome;
        this.forza = forza;
        this.salute = salute;
    }

    public abstract void gridoDiBattaglia();

    protected void combatti() {
        System.out.println(nome + " scende in combattimento infliggendo " + forza + " punti danno!");

    }

    protected void riposa() {
        System.out.println(nome + " si riposa e recupera salute.");
        salute += 10;

    }

    protected void avanza() {
        System.out.println(nome + " sta avanzando verso il campo di battaglia.");
    }

    @Override
    public String toString() {
        return "Soldato {" +
                "nome='" + nome + '\'' +
                ", salute=" + salute +
                ", forza=" + forza +
                '}';
    }
    
    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public int getSalute() {
        return salute;
    }


    public void setSalute(int salute) {
        this.salute = salute;
    }

    public int getForza() {
        return forza;
    }

    public void setForza(int forza) {
        this.forza = forza;
    }
}