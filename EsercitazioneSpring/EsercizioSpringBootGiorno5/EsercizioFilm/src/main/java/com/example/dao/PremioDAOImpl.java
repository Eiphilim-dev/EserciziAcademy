package com.example.dao;

import com.example.model.Film;
import com.example.model.Premio;
import com.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PremioDAOImpl implements IDao<Premio>{

    @Override
    public void inserisciTutti(List<Premio> listaPremi) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession();) {

            transaction = session.beginTransaction();

            for (Premio lp: listaPremi) {
                session.merge(lp);
            }

            transaction.commit();
        }catch(ConstraintViolationException e){
            e.printStackTrace();
            System.out.println("Eccezione per la chiave primaria");
            transaction.rollback();
        }catch(HibernateException e) {
            e.printStackTrace();
            System.out.println("Eccezione specifica di Hibernate");
            transaction.rollback();
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Eccezione generica");
            transaction.rollback();
        }
    }

    @Override
    public List<Premio> cercaTutti() {
        List<Premio> lista = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession();) {

            lista = session.createQuery("from Premio", Premio.class).list();

        }catch(ConstraintViolationException e){
            e.printStackTrace();
            System.out.println("Eccezione per la chiave primaria");

        }catch(HibernateException e) {
            e.printStackTrace();
            System.out.println("Eccezione specifica di Hibernate");

        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Eccezione generica");

        }
        return lista;
    }

    @Override
    public Premio cercaUno(Integer id_premio) {
        Premio premio= new Premio();
        try(Session session = HibernateUtil.getSessionFactory().openSession();) {

            Query<Premio> query = session.createQuery("from Premio where id_premio = :id_premio", Premio.class);

            query.setParameter("id_premio", id_premio);

            //noinspection removal
            premio = query.getSingleResult();

        }catch(ConstraintViolationException e){
            e.printStackTrace();
            System.out.println("Eccezione per la chiave primaria");

        }catch(HibernateException e) {
            e.printStackTrace();
            System.out.println("Eccezione specifica di Hibernate");

        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Eccezione generica");

        }

        return premio;
    }

    @Override
    public void ModificaNome(Integer id_premio, String nome) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession();) {

            transaction = session.beginTransaction();

            MutationQuery query = session.createMutationQuery("update Premio set nome = :nome where id_premio = :id_premio");
            query.setParameter("nome", nome);
            query.setParameter("id_premio", id_premio);

            query.executeUpdate();

            transaction.commit();
        }catch(ConstraintViolationException e){
            e.printStackTrace();
            System.out.println("Eccezione per la chiave primaria");
            transaction.rollback();
        }catch(HibernateException e) {
            e.printStackTrace();
            System.out.println("Eccezione specifica di Hibernate");
            transaction.rollback();
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Eccezione generica");
            transaction.rollback();
        }

    }

    @Override
    public void CancellaUno(Integer id_premio) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession();) {

            transaction = session.beginTransaction();
            Premio premio = session.get(Premio.class, id_premio);

            if(premio != null) {
                Film film = premio.getFilm();

                if(film != null) {
                    film.getPremi().remove(premio);
                    session.merge(film);
                }

                session.remove(premio);
            }

            transaction.commit();
        }catch(ConstraintViolationException e){
            e.printStackTrace();
            System.out.println("Eccezione per la chiave primaria");
            transaction.rollback();
        }catch(HibernateException e) {
            e.printStackTrace();
            System.out.println("Eccezione specifica di Hibernate");
            transaction.rollback();
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Eccezione generica");
            transaction.rollback();
        }
    }
}
