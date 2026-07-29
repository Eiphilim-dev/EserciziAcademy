package academy.dao;

import academy.model.Automobile;
import academy.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class AutomobileDao implements IDao<Automobile, Integer>{
    @Override
    public void save(Automobile entity) {
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
            System.out.println("Errore durante il salvataggio della Macchina: " + entity.toString());
            throw new RuntimeException("Impossibile salvare l'auto nel Database", e);

        }
    }

    @Override
    public Automobile findById(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Automobile.class, id);

        } catch (HibernateException e) {
            System.out.println("Errore durante la ricerca della Macchina con ID: " + id);
            throw new RuntimeException("Impossibile prelevare la Macchina con ID: " + id, e);

        }
    }

    @Override
    public List<Automobile> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Automobile", Automobile.class).list();

        } catch (HibernateException e) {
            System.out.println("Errore durante il recupero di tutte le macchine");
            throw new RuntimeException("Impossibile recuperare l'elenco delle macchine", e);

        }
    }

    @Override
    public void update(Automobile entity) {
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
            System.out.println("Errore durante l'aggiornamento della macchina: " + entity.toString());
            throw new RuntimeException("Impossibile aggiornare la macchina nel Database", e);

        }
    }

    @Override
    public void delete(Automobile entity) {
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
            System.out.println("Errore durante l'eliminazione della macchina: " + entity.toString());
            throw new RuntimeException("Impossibile eliminare la macchina del Database", e);

        }
    }

    @Override
    public void deleteAll() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createMutationQuery("DELETE FROM Automobile").executeUpdate();
            transaction.commit();

        } catch (HibernateException e) {
            System.out.println("Errore durante il recupero di tutte le persone");
            throw new RuntimeException("Impossibile recuperare l'elenco delle persone", e);

        }
    }
}
