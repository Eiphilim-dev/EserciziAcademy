package EserciziGiorno10.Esercizio5;

import java.util.ArrayList;

public class TestGara {
    public static void main(String[] args) {
        ArrayList<Pilota> listaPilotiDelMain = new ArrayList<>();

        Auto auto1 = new Auto("Ferrari");
        Pilota p1 = new Pilota("Leclerc", auto1);
        listaPilotiDelMain.add(p1);

        Auto auto2 = new Auto("Mercedes");
        Pilota p2 = new Pilota("Hamilton", auto2);
        listaPilotiDelMain.add(p2);
        
        Gara monza = new Gara("Monza");
        
        monza.creaGrigliaDiPartenza(listaPilotiDelMain);
        monza.corriGara();
    }
}
