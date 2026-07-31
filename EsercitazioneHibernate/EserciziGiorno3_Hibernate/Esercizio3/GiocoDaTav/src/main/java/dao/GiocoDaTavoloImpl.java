package dao;

import config.HibernateUtil;
import entity.GiocoDaTavolo;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GiocoDaTavoloImpl implements IDao<GiocoDaTavolo, String> {

    @Override
    public void save(GiocoDaTavolo entity) {
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
                    System.out.println("Rollback fallito durante il salvataggio.");
                }
            }
            System.out.println("Errore durante il salvataggio del Gioco Da Tavolo: " + entity.toString());
            throw new RuntimeException("Impossibile salvare il Gioco Da Tavolo nel Database", e);
        }
    }

    @Override
    public void saveAll(List<GiocoDaTavolo> entities) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            for (GiocoDaTavolo entity : entities) {
                session.merge(entity);
            }

            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null && transaction.getStatus().canRollback()) {
                try {
                    transaction.rollback();
                } catch (Exception rollbackEx) {
                    System.out.println("Rollback fallito durante il salvataggio.");
                }
            }
            System.out.println("Errore durante il salvataggio dei Gioco Da Tavolo: " + entities.toString());
            throw new RuntimeException("Impossibile salvare i Gioco Da Tavolo nel Database", e);
        }
    }

    @Override
    public GiocoDaTavolo findByIdentification(String identification) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(GiocoDaTavolo.class, identification);

        } catch (EntityNotFoundException e) {
            return null;

        } catch (Exception e) {
            System.out.println("Errore durante la ricerca del Gioco Da Tavolo con ID: " + identification);
            throw new RuntimeException("Impossibile prelevare il Gioco Da Tavolo con ID: " + identification, e);
        }
    }

    @Override
    public List<GiocoDaTavolo> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM GiocoDaTavolo", GiocoDaTavolo.class).list();

        } catch (HibernateException e) {
            System.out.println("Errore durante il recupero di tutti i Giochi Da Tavolo");
            throw new RuntimeException("Impossibile recuperare l'elenco dei Gioco Da Tavolo", e);

        }
    }

    public boolean isGiocoAdattoPerEta(String giocoId, Integer eta) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(gioco) FROM GiocoDaTavolo gioco WHERE gioco.nome = :nome AND gioco.etaMinima <= :eta";

            Long count = session.createQuery(hql, Long.class)
                    .setParameter("nome", giocoId)
                    .setParameter("eta", eta)
                    .getSingleResult();

            return count > 0;
        }
    }
}
