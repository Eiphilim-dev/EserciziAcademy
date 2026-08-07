package com.example.dao;

import com.example.model.Articolo;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ArticoloDaoImpl implements IDao<Articolo, String> {

    @Override
    public void salva(Articolo articolo) {
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(articolo);

        transaction.commit();
        session.close();
    }

    @Override
    public Articolo trovaPerId(String codice) {
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Articolo articolo = session.get(Articolo.class, codice);

        session.close();

        return articolo;
    }

    @Override
    public List<Articolo> trovaTutti() {
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        List<Articolo> articoli = session
                .createQuery("FROM Articolo", Articolo.class)
                .getResultList();

        session.close();

        return articoli;
    }

    @Override
    public void aggiorna(Articolo articolo) {
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();

        session.merge(articolo);

        transaction.commit();
        session.close();
    }

    @Override
    public void elimina(String codice) {
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();

        Articolo articolo = session.get(Articolo.class, codice);

        if (articolo != null) {
            session.remove(articolo);
        }

        transaction.commit();
        session.close();
    }
}