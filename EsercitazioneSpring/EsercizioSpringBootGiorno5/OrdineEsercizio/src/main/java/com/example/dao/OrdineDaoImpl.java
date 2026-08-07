package com.example.dao;

import com.example.model.Ordine;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrdineDaoImpl implements IDao<Ordine, Long> {

    @Override
    public void salva(Ordine ordine) {
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(ordine);

        transaction.commit();
        session.close();
    }

    @Override
    public Ordine trovaPerId(Long id) {
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Ordine ordine = session.get(Ordine.class, id);

        session.close();

        return ordine;
    }

    @Override
    public List<Ordine> trovaTutti() {
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        List<Ordine> ordini = session
                .createQuery("FROM Ordine", Ordine.class)
                .getResultList();

        session.close();

        return ordini;
    }

    @Override
    public void aggiorna(Ordine ordine) {
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();

        session.merge(ordine);

        transaction.commit();
        session.close();
    }

    @Override
    public void elimina(Long id) {
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();

        Ordine ordine = session.get(Ordine.class, id);

        if (ordine != null) {
            session.remove(ordine);
        }

        transaction.commit();
        session.close();
    }
}