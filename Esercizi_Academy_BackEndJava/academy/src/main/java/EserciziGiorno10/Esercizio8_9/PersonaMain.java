package EserciziGiorno10.Esercizio8_9;

public class PersonaMain {
    public static void main(String[] args) {
        Persona s = new Studente("Mario", "Rossi", 20);
        Persona i = new Insegnante("Giovanni", "Bianchi", 40, "Matematica");
        
        mostraDettagliPersona(s);
        mostraDettagliPersona(i);

    }

    public static void mostraDettagliPersona(Persona p) {
        System.out.println("--- Dettagli Info Persona ---");
        System.out.println(p.toString());

        if (p instanceof Studente) {
            Studente studente = (Studente) p;
            studente.studia();
            studente.calcolaMediaVoti(8, 9, 7);

        } else if (p instanceof Insegnante) {
            Insegnante insegnante = (Insegnante) p;
            insegnante.insegna();

        }
    }
}
