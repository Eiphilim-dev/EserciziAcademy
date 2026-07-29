package academy.dao;

import academy.model.Persona;
import academy.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.Session;

import java.util.List;

public class PersonaDaoImpl implements IDao<Persona, Integer>{

    @Override
    public void save(Persona entity) {
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
            System.out.println("Errore durante il salvataggio della persona: " + entity.toString());
            throw new RuntimeException("Impossibile salvare la persona del Database", e);

        }
    }

    @Override
    public Persona findById(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Persona.class, id);

        } catch (HibernateException e) {
            System.out.println("Errore durante la ricerca della Persona con ID: " + id);
            throw new RuntimeException("Impossibile prelevare la persona con ID: " + id, e);

        }
    }

    @Override
    public List<Persona> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Persona", Persona.class).list();

        } catch (HibernateException e) {
            System.out.println("Errore durante il recupero di tutte le persone");
            throw new RuntimeException("Impossibile recuperare l'elenco delle persone", e);

        }
    }

    @Override
    public void update(Persona entity) {
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
            System.out.println("Errore durante l'aggiornamento della persona: " + entity.toString());
            throw new RuntimeException("Impossibile aggiornare la persona del Database", e);

        }
    }

    @Override
    public void delete(Persona entity) {
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
            System.out.println("Errore durante l'eliminazione della persona: " + entity.toString());
            throw new RuntimeException("Impossibile eliminare la persona del Database", e);

        }
    }

    @Override
    public void deleteAll() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createMutationQuery("DELETE FROM Persona").executeUpdate();
            transaction.commit();

        } catch (HibernateException e) {
            System.out.println("Errore durante il recupero di tutte le persone");
            throw new RuntimeException("Impossibile recuperare l'elenco delle persone", e);

        }
    }
}
