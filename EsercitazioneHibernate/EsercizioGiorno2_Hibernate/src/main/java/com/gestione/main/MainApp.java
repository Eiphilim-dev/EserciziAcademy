package com.gestione.main;

import com.gestione.config.HibernateUtil;
import com.gestione.dao.CorsoDaoImpl;
import com.gestione.dao.IDao;
import com.gestione.dao.MatricolaDaoImpl;
import com.gestione.dao.StudenteDaoImpl;
import com.gestione.entity.Corso;
import com.gestione.entity.Matricola;
import com.gestione.entity.Studente;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    static void main(String[] args) {
        System.out.println("=== INIZIO TEST GESTIONE STUDENTI (Senza Optional) ===\n");

        IDao<Studente, Integer> studenteDao = new StudenteDaoImpl();
        IDao<Matricola, Integer> matricolaDao = new MatricolaDaoImpl();
        IDao<Corso, Integer> corsoDao = new CorsoDaoImpl();


        // 1. CREAZIONE E SALVATAGGIO CORSI (Test saveAll)

        System.out.println("1. Test saveAll(): Salvataggio di 5 Corsi...");
        Corso c1 = new Corso("Java Developer", "Programmazione Java base e avanzata");
        Corso c2 = new Corso("Spring Boot", "Sviluppo di API REST Web");
        Corso c3 = new Corso("Database SQL", "Progettazione database MySQL");
        Corso c4 = new Corso("Frontend Angular", "Single Page Application");
        Corso c5 = new Corso("DevOps Basics", "Docker e Git");

        List<Corso> listaCorsi = new ArrayList<>();
        listaCorsi.add(c1);
        listaCorsi.add(c2);
        listaCorsi.add(c3);
        listaCorsi.add(c4);
        listaCorsi.add(c5);

        // Salvataggio di tutti i corsi insieme
        corsoDao.saveAll(listaCorsi);
        System.out.println("-> Corsi salvati correttamente!\n");


        // 2. CREAZIONE STUDENTI, MATRICOLE E RELAZIONI (Test save)

        System.out.println("2. Test save(): Salvataggio di 5 Studenti con Matricola (1:1) e Corsi (N:M)...");

        Matricola m1 = new Matricola("MAT-001");
        Matricola m2 = new Matricola("MAT-002");
        Matricola m3 = new Matricola("MAT-003");
        Matricola m4 = new Matricola("MAT-004");
        Matricola m5 = new Matricola("MAT-005");

        Studente s1 = new Studente("Mario", "Rossi");
        s1.setMatricola(m1);
        s1.addCorso(c1);
        s1.addCorso(c3);

        Studente s2 = new Studente("Luca", "Bianchi");
        s2.setMatricola(m2);
        s2.addCorso(c1);
        s2.addCorso(c2);

        Studente s3 = new Studente("Giulia", "Verdi");
        s3.setMatricola(m3);
        s3.addCorso(c2);
        s3.addCorso(c4);

        Studente s4 = new Studente("Francesca", "Neri");
        s4.setMatricola(m4);
        s4.addCorso(c3);
        s4.addCorso(c5);

        Studente s5 = new Studente("Alessandro", "Gialli");
        s5.setMatricola(m5);
        s5.addCorso(c1);
        s5.addCorso(c5);

        // Salvataggio dei singoli studenti
        studenteDao.save(s1);
        studenteDao.save(s2);
        studenteDao.save(s3);
        studenteDao.save(s4);
        studenteDao.save(s5);
        System.out.println("-> 5 Studenti e Matricole salvati correttamente!\n");


        // 3. TEST findAll()

        System.out.println("3. Test findAll(): Stampa di tutti gli studenti nel DB:");
        List<Studente> studenti = studenteDao.findAll();
        for (Studente s : studenti) {
            System.out.println(" - " + s.getNome() + " " + s.getCognome() +
                    " | Matricola: " + s.getMatricola() +
                    " | Numero corsi: " + s.getCorsi().size());
        }
        System.out.println();


        // 4. TEST findById()

        System.out.println("4. Test findById(): Cerca lo studente con ID = " + s1.getStudente_id());
        Studente studenteTrovato = studenteDao.findById(s1.getStudente_id());
        if (studenteTrovato != null) {
            System.out.println("-> Trovato: " + studenteTrovato.getNome() + " " + studenteTrovato.getCognome());
        } else {
            System.out.println("-> Studente non trovato!");
        }
        System.out.println();


        // 5. TEST update()

        System.out.println("5. Test update(): Modifica del cognome di Mario Rossi...");
        if (studenteTrovato != null) {
            studenteTrovato.setCognome("Rossi-Modificato");
            studenteDao.update(studenteTrovato);

            // Verifica modifica
            Studente studenteModificato = studenteDao.findById(s1.getStudente_id());
            System.out.println("-> Cognome aggiornato nel DB: " + studenteModificato.getCognome());
        }
        System.out.println();


        // 6. TEST delete()

        System.out.println("6. Test delete(): Eliminazione dello studente ID = " + s5.getStudente_id());
        Studente daEliminare = studenteDao.findById(s5.getStudente_id());
        if (daEliminare != null) {
            studenteDao.delete(daEliminare);
            System.out.println("-> Studente eliminato correttamente.");
        }
        System.out.println("Studenti rimasti nel DB: " + studenteDao.findAll().size() + "\n");


        // 7. TEST deleteAll()

//        System.out.println("7. Test deleteAll(): Svuotamento delle tabelle...");
//        studenteDao.deleteAll();
//        matricolaDao.deleteAll();
//        corsoDao.deleteAll();
//
//        System.out.println("-> Studenti nel DB: " + studenteDao.findAll().size());
//        System.out.println("-> Matricole nel DB: " + matricolaDao.findAll().size());
//        System.out.println("-> Corsi nel DB: " + corsoDao.findAll().size());
//
        // Chiusura connessione
        HibernateUtil.shutdown();
        System.out.println("\n=== TEST COMPLETATO ===");
    }
}
