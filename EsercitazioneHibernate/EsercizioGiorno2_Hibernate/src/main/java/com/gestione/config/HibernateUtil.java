package com.gestione.config;

import com.gestione.entity.Corso;
import com.gestione.entity.Matricola;
import com.gestione.entity.Studente;
import jakarta.annotation.Nonnull;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties properties = getProperties();

                configuration.setProperties(properties);

                configuration.addAnnotatedClass(Studente.class);
                configuration.addAnnotatedClass(Matricola.class);
                configuration.addAnnotatedClass(Corso.class);

                sessionFactory = configuration.buildSessionFactory();

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Errore durante la creazione del SessionFactory" , e);

            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();

        }
    }

    @Nonnull
    private static Properties getProperties() {
        Properties properties = new Properties();

        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/test_Uni_db?createDatabaseIfNotExist=true");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "employeepassW.");

        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.FORMAT_SQL, "true");

        properties.put(Environment.HBM2DDL_AUTO, "update");
        return properties;

    }
}
