package com.example.util;

import com.example.model.Articolo;
import com.example.model.Ordine;
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

                configuration.addAnnotatedClass(Articolo.class);
                configuration.addAnnotatedClass(Ordine.class);

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
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/film_db_eser?createDatabaseIfNotExist=true");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "yourpass.");

        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.FORMAT_SQL, "true");

        properties.put(Environment.HBM2DDL_AUTO, "update");
        return properties;

    }
}
