package com.gestione.dao;

import com.gestione.config.HibernateUtil;
import com.gestione.entity.Corso;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CorsoDaoImpl implements IDao<Corso, Integer>{

    @Override
    public void save(Corso entity) {
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
            System.out.println("Errore durante il salvataggio del Corso: " + entity.toString());
            throw new RuntimeException("Impossibile salvare il Corso nel Database", e);

        }
    }

    public void saveAll(List<Corso> entities) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            for (Corso entity : entities) {
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
            System.out.println("Errore durante il salvataggio dei Corsi: " + entities.toString());
            throw new RuntimeException("Impossibile salvare i Corsi nel Database", e);

        }
    }

    @Override
    public Corso findById(Integer corso_id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Corso.class, corso_id);

        } catch (HibernateException e) {
            System.out.println("Errore durante la ricerca del Corso con ID: " + corso_id.toString());
            throw new RuntimeException("Impossibile prelevare il Corso con ID: " + corso_id, e);

        }
    }

    @Override
    public List<Corso> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Corso", Corso.class).list();

        } catch (HibernateException e) {
            System.out.println("Errore durante il recupero di tutti i corsi");
            throw new RuntimeException("Impossibile recuperare l'elenco dei corsi", e);

        }
    }

    @Override
    public void update(Corso entity) {
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
            System.out.println("Errore durante l'aggiornamento del Corso: " + entity.toString());
            throw new RuntimeException("Impossibile aggiornare il Corso nel Database", e);

        }
    }

    @Override
    public void delete(Corso entity) {
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
            System.out.println("Errore durante l'eliminazione del Corso: " + entity.toString());
            throw new RuntimeException("Impossibile eliminare il Corso nel Database", e);

        }
    }

    @Override
    public void deleteAll() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createMutationQuery("DELETE FROM Corso").executeUpdate();
            transaction.commit();

        } catch (HibernateException e) {
            System.out.println("Errore durante l'eliminazione di tutti i corsi");
            throw new RuntimeException("Impossibile eliminare l'elenco dei corsi", e);

        }
    }
}
