package dao;

import config.HibernateUtil;
import entity.GiocoDaTavolo;
import entity.Partecipante;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PartecipanteDaoImpl implements IDao<Partecipante,  Integer>{

    @Override
    public void save(Partecipante entity) {
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
            System.out.println("Errore durante il salvataggio del Partecipante: " + entity.toString());
            throw new RuntimeException("Impossibile salvare il Partecipante nel Database", e);

        }
    }

    @Override
    public void saveAll(List<Partecipante> entity) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            for (Partecipante entities : entity) {
                session.persist(entities);
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
            System.out.println("Errore durante il salvataggio dei Partecipanti: " + entity.toString());
            throw new RuntimeException("Impossibile salvare i Partecipanti nel Database", e);

        }
    }

    @Override
    public Partecipante findByIdentification(Integer identification) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Partecipante.class, identification);

        } catch (HibernateException e) {
            System.out.println("Errore durante la ricerca del Partecipante con ID: " + identification.toString());
            throw new RuntimeException("Impossibile prelevare il Partecipante con ID: " + identification, e);

        }
    }

    @Override
    public List<Partecipante> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM GiocoDaTavolo", Partecipante.class).list();

        } catch (HibernateException e) {
            System.out.println("Errore durante il recupero di tutti i Partecipanti");
            throw new RuntimeException("Impossibile recuperare l'elenco dei Partecipanti", e);

        }
    }
}
