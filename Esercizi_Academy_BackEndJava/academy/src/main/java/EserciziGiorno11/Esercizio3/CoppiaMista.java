package EserciziGiorno11.Esercizio3;

@SuppressWarnings("all")
public class CoppiaMista<T, U> {
    private T uno;
    private U due;

    public void salva(T uno, U due) {
        this.uno = uno;
        this.due = due;
    }

    public T getUno() {
        return uno;
    }

    public U getDue() {
        return due;
    }
}
