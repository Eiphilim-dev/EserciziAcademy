package com.gestione.dao;

import com.gestione.config.HibernateUtil;
import com.gestione.entity.Matricola;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MatricolaDaoImpl implements IDao<Matricola, Integer>{

    @Override
    public void save(Matricola entity) {
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
            System.out.println("Errore durante il salvataggio della Matricola: " + entity.toString());
            throw new RuntimeException("Impossibile salvare la Matricola nel Database", e);

        }
    }

    public void saveAll(List<Matricola> entities) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            for (Matricola entity : entities) {
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
            System.out.println("Errore durante il salvataggio delle Matricole: " + entities.toString());
            throw new RuntimeException("Impossibile salvare le Matricole nel Database", e);

        }
    }

    @Override
    public Matricola findById(Integer matricola_id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Matricola.class, matricola_id);

        } catch (HibernateException e) {
            System.out.println("Errore durante la ricerca della Matricola con ID: " + matricola_id.toString());
            throw new RuntimeException("Impossibile prelevare la Matricola con ID: " + matricola_id, e);

        }
    }

    @Override
    public List<Matricola> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Matricola", Matricola.class).list();

        } catch (HibernateException e) {
            System.out.println("Errore durante il recupero di tutte le Matricole");
            throw new RuntimeException("Impossibile recuperare l'elenco delle Matricole", e);

        }
    }

    @Override
    public void update(Matricola entity) {
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
            System.out.println("Errore durante l'aggiornamento della Matricola: " + entity.toString());
            throw new RuntimeException("Impossibile aggiornare la Matricola nel Database", e);

        }
    }

    @Override
    public void delete(Matricola entity) {
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
            System.out.println("Errore durante l'eliminazione della Matricola: " + entity.toString());
            throw new RuntimeException("Impossibile eliminare la Matricola nel Database", e);

        }
    }

    @Override
    public void deleteAll() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createMutationQuery("DELETE FROM Matricola").executeUpdate();
            transaction.commit();

        } catch (HibernateException e) {
            System.out.println("Errore durante l'eliminazione di tutte le Matricole");
            throw new RuntimeException("Impossibile eliminare l'elenco delle Matricole", e);

        }
    }
}
