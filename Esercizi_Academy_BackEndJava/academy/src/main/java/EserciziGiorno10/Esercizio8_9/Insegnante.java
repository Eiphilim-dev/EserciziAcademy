package EserciziGiorno10.Esercizio8_9;

public class Insegnante extends Persona{
    private String materia;

    public Insegnante(String nome, String cognome, int eta, String materia) {
        super(nome, cognome, eta);
        this.materia = materia;
    }

    public void insegna() {
        System.out.println("Sta insegnando");

    }

    @Override
    public String toString() {
    return "Insegnante{nome='" + getNome() + "', cognome='" + getCognome() + "', eta=" + getEta() + "', materia=" + this.materia + "}";
    
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
