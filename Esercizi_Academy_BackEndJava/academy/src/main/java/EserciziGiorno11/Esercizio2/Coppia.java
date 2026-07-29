package EserciziGiorno11.Esercizio2;

@SuppressWarnings("all")
public class Coppia<T> {
    private T uno;
    private T due;

    public void salva(T uno, T due) {
        this.uno = uno;
        this.due = due;
    }

    public T getUno() {
        return uno;
    }

    public T getDue() {
        return due;
    }
}
