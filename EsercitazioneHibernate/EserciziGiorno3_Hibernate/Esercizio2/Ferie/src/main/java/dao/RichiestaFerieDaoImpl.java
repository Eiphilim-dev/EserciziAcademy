package dao;

import config.HibernateUtil;
import entity.RichiestaFerie;
import enums.StatoRichiesta;
import inteface.IDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RichiestaFerieDaoImpl implements IDao<RichiestaFerie, Integer> {

    @Override
    public void save(RichiestaFerie entity) {
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
            System.out.println("Errore durante il salvataggio della RichiestaFerie: " + entity.toString());
            throw new RuntimeException("Impossibile salvare la RichiestaFerie nel Database", e);

        }
    }

    @Override
    public void saveAll(List<RichiestaFerie> entity) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            for (RichiestaFerie entities : entity) {
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
            System.out.println("Errore durante il salvataggio delle Richieste: " + entity.toString());
            throw new RuntimeException("Impossibile salvare le Richieste nel Database", e);

        }
    }

    @Override
    public void update(RichiestaFerie entity) {
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
            System.out.println("Errore durante l'aggiornamento della Richiesta: " + entity.toString());
            throw new RuntimeException("Impossibile aggiornare il Corso nel Database", e);

        }
    }
}
