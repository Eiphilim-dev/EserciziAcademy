package EserciziGiorno7.Esercizio4_5;

public class Fante extends Soldato {

    public Fante(String nome, int forza, int salute) {
        super(nome, forza, salute);
    }

    @Override
    public void gridoDiBattaglia() {
        System.out.println(getNome() + " grida: 'Per la gloria del regno!'");
    }

    @Override
    public String toString() {
        return "Fante {" +
                "nome='" + getNome() + '\'' +
                ", salute=" + getSalute() +
                ", forza=" + getForza() +
                '}';
    }
    
}
