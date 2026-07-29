package academy.util;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Getter
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Inizializzazione della SessionFactory fallita." + ex);
            throw new ExceptionInInitializerError(ex);

        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;

    }

    public static void shutdown() {
        getSessionFactory().close();

    }
}
