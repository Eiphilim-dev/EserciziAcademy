package main;

import dao.RichiestaFerieDaoImpl;
import entity.RichiestaFerie;

import java.time.LocalDate;
import java.util.Date;

public class MainApp {
    static void main(String[] args) {
        RichiestaFerieDaoImpl  richiestaFerieDao = new RichiestaFerieDaoImpl();

        RichiestaFerie r1 = new RichiestaFerie(
                "m.rossi@azienda.it",
                LocalDate.of(2026, 8, 10),
                LocalDate.of(2026, 8, 21),
                "Ferie estive programmate"
        );

        RichiestaFerie r2 = new RichiestaFerie(
                "s.bianchi@azienda.it",
                LocalDate.of(2026, 9, 15),
                LocalDate.of(2026, 9, 17),
                "Esame universitario di Informatica"
        );

        richiestaFerieDao.save(r1);
        richiestaFerieDao.save(r2);

        r2.accettaRichiesta();
        r2.setMotivazioneRifiuto("Nessun giorno disponibile");
        richiestaFerieDao.update(r2);
    }
}
