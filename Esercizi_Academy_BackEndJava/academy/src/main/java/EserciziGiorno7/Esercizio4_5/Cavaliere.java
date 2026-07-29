package EserciziGiorno7.Esercizio4_5;

public class Cavaliere extends Soldato{
    private String cavallo;

    public Cavaliere(String nome, int forza, int salute, String cavallo) {
        super(nome, forza, salute);
        this.cavallo = cavallo;
    }

    @Override
    public void gridoDiBattaglia() {
        System.out.println(getNome() + " grida: Per il regno!");
    }

    @Override
    public String toString() {
        return "Cavaliere {" +
                "nome='" + getNome() + '\'' +
                ", salute=" + getSalute() +
                ", forza=" + getForza() +
                ", cavallo='" + cavallo + '\'' +
                '}';
                
    }
}
