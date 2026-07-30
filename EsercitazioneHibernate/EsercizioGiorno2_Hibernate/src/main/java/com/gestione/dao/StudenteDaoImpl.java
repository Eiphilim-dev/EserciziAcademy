package com.gestione.dao;


import com.gestione.config.HibernateUtil;
import com.gestione.entity.Studente;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudenteDaoImpl implements IDao<Studente, Integer> {

    @Override
    public void save(Studente entity) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null && transaction.getStatus().canRollback()) {

                try {
                    transaction.rollback();

                } catch (Exception rollbackEx) {
                    System.out.println("Rollback fallito durante il salvaggio.");

                }
            }
            System.out.println("Errore durante il salvataggio dello Studente: " + entity.toString());
            throw new RuntimeException("Impossibile salvare lo Studente nel Database", e);

        }
    }

    public void saveAll(List<Studente> entities) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            for (Studente entity : entities) {
                session.persist(entity);
            }

            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null && transaction.getStatus().canRollback()) {

                try {
                    transaction.rollback();

                } catch (Exception rollbackEx) {
                    System.out.println("Rollback fallito durante il salvaggio.");

                }
            }
            System.out.println("Errore durante il salvataggio degli Studenti: " + entities.toString());
            throw new RuntimeException("Impossibile salvare gli Studenti nel Database", e);

        }
    }

    @Override
    public Studente findById(Integer studente_id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Studente.class, studente_id);

        } catch (HibernateException e) {
            System.out.println("Errore durante la ricerca dello Studente con ID: " + studente_id.toString());
            throw new RuntimeException("Impossibile prelevare dello Studente con ID: " + studente_id, e);

        }
    }

    @Override
    public List<Studente> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Studente", Studente.class).list();

        } catch (HibernateException e) {
            System.out.println("Errore durante il recupero di tutti gli Studenti");
            throw new RuntimeException("Impossibile recuperare l'elenco degli Studenti", e);

        }
    }

    @Override
    public void update(Studente entity) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null && transaction.getStatus().canRollback()) {

                try {
                    transaction.rollback();

                } catch (Exception rollbackEx) {
                    System.out.println("Rollback fallito durante l'aggiornamento.");

                }
            }
            System.out.println("Errore durante l'aggiornamento dello Studente: " + entity.toString());
            throw new RuntimeException("Impossibile aggiornare lo Studente nel Database", e);

        }
    }

    @Override
    public void delete(Studente entity) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(session.contains(entity) ? entity : session.merge(entity));
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null && transaction.getStatus().canRollback()) {

                try {
                    transaction.rollback();

                } catch (Exception rollbackEx) {
                    System.out.println("Rollback fallito durante l'eliminazione.");

                }
            }
            System.out.println("Errore durante l'eliminazione dello Studente: " + entity.toString());
            throw new RuntimeException("Impossibile eliminare lo Studente nel Database", e);

        }
    }

    @Override
    public void deleteAll() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createMutationQuery("DELETE FROM Studente").executeUpdate();
            transaction.commit();

        } catch (HibernateException e) {
            System.out.println("Errore durante l'eliminazione di tutti gli Studenti");
            throw new RuntimeException("Impossibile eliminare l'elenco degli Studenti", e);

        }
    }
}
