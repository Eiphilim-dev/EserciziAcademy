package com.example.dao;

import com.example.model.Film;
import com.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public interface FilmDAOImpl {
    public class FilmDAO implements IDao<Film> {

        @Override
        public void inserisciTutti(List<Film> listaFilm) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession();) {

                transaction = session.beginTransaction();

                for (Film f : listaFilm) {
                    session.merge(f);
                }

                transaction.commit();

            } catch (HibernateException e) {
                e.printStackTrace();
                System.out.println("Eccezione specifica di Hibernate");
                transaction.rollback();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Eccezione generica");
                transaction.rollback();
            }

        }

        @Override
        public List<Film> cercaTutti() {
            List<Film> lista = new ArrayList<>();
            try (Session session = HibernateUtil.getSessionFactory().openSession();) {

                lista = session.createQuery("from Film", Film.class).list();

            } catch (HibernateException e) {
                e.printStackTrace();
                System.out.println("Eccezione specifica di Hibernate");

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Eccezione generica");

            }
            return lista;
        }

        @Override
        public Film cercaUno(Integer id_film) {
            Film partecipante = new Film();
            try (Session session = HibernateUtil.getSessionFactory().openSession();) {

                Query<Film> query = session.createQuery("from Film where id_film = :id_film", Film.class);

                query.setParameter("id_film", id_film);

                //noinspection removal
                partecipante = query.getSingleResultOrNull();

            } catch (ConstraintViolationException e) {
                e.printStackTrace();
                System.out.println("Eccezione per la chiave primaria");

            } catch (HibernateException e) {
                e.printStackTrace();
                System.out.println("Eccezione specifica di Hibernate");

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Eccezione generica");

            }

            return partecipante;
        }

        @Override
        public void ModificaNome(Integer id_film, String titolo) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession();) {

                transaction = session.beginTransaction();

                MutationQuery query = session.createMutationQuery("update Film set titolo = :titolo where id_film = :id_film");
                query.setParameter("titolo", titolo);
                query.setParameter("id_film", id_film);

                query.executeUpdate();

                transaction.commit();
            } catch (ConstraintViolationException e) {
                e.printStackTrace();
                System.out.println("Eccezione per la chiave primaria");
                transaction.rollback();
            } catch (HibernateException e) {
                e.printStackTrace();
                System.out.println("Eccezione specifica di Hibernate");
                transaction.rollback();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Eccezione generica");
                transaction.rollback();
            }

        }

        @Override
        public void CancellaUno(Integer id_film) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession();) {

                transaction = session.beginTransaction();
                Film film = session.get(Film.class, id_film);

                if (film != null) {

                    film.setPremi(null);
                    session.merge(film);
                    session.remove(film);
                }


                transaction.commit();
            } catch (ConstraintViolationException e) {
                e.printStackTrace();
                System.out.println("Eccezione per la chiave primaria");
                transaction.rollback();
            } catch (HibernateException e) {
                e.printStackTrace();
                System.out.println("Eccezione specifica di Hibernate");
                transaction.rollback();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Eccezione generica");
                transaction.rollback();
            }
        }
    }
}

