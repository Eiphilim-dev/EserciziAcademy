package com.example;

import com.example.dao.FilmDAOImpl;
import com.example.dao.IDao;
import com.example.dao.PremioDAOImpl;
import com.example.model.Film;
import com.example.model.Premio;

import java.util.List;

public class MainApp {
    static void main(String[] args) {
        IDao<Film> filmDAO = new FilmDAOImpl.FilmDAO();

        System.out.println("--- TEST FILM ---");

        // 1. Inserisci tutti
        List<Film> listaFilm = List.of(
                new Film("Inception", "Fantascienza"),
                new Film("Avatar", "Fantascienza")
        );
        filmDAO.inserisciTutti(listaFilm);

        // 2. Cerca tutti
        System.out.println("Tutti i film:");
        List<Film> tuttiIFilm = filmDAO.cercaTutti();
        for (Film film : tuttiIFilm) {
            System.out.println(film);
        }

        // 3. Cerca uno per ID
        System.out.println("\nFilm trovato con ID 1:");
        System.out.println(filmDAO.cercaUno(1));

        // 4. Modifica titolo
        filmDAO.ModificaNome(1, "Inception - Director's Cut");
        System.out.println("\nDopo la modifica:");
        System.out.println(filmDAO.cercaUno(1));

        // 5. Cancella uno
        filmDAO.CancellaUno(2);
        System.out.println("\nLista film dopo cancellazione ID 2:");
        for (Film film : filmDAO.cercaTutti()) {
            System.out.println(film);
        }

        // TEST PREMIO DAO
        IDao<Premio> premioDAO = new PremioDAOImpl();

        System.out.println("\n--- TEST PREMIO ---");

        // 1. Inserisci tutti
        List<Premio> listaPremi = List.of(
                new Premio(10L, "Oscar", "Migliori Effetti Speciali"),
                new Premio(20L, "Leone d'Oro", "Miglior Film")
        );
        premioDAO.inserisciTutti(listaPremi);

        // 2. Cerca tutti
        System.out.println("Tutti i premi:");
        List<Premio> tuttiIPremi = premioDAO.cercaTutti();
        for (Premio premio : tuttiIPremi) {
            System.out.println(premio);
        }

        // 3. Cerca uno per ID
        System.out.println("\nPremio trovato con ID 10:");
        System.out.println(premioDAO.cercaUno(10));

        // 4. Modifica nome
        premioDAO.ModificaNome(10, "Oscar Academy Award");
        System.out.println("\nDopo la modifica:");
        System.out.println(premioDAO.cercaUno(10));

        // 5. Cancella uno
        premioDAO.CancellaUno(20);
        System.out.println("\nLista premi dopo cancellazione ID 20:");
        for (Premio premio : premioDAO.cercaTutti()) {
            System.out.println(premio);
        }
    }
}
