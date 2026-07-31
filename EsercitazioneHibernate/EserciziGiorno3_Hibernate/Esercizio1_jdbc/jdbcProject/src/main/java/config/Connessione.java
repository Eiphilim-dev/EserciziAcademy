package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connessione {

    public static Connection getConnection() throws SQLException {

        Properties prop = new Properties();

        InputStream input;

        try {

            input = Connessione.class.getResourceAsStream("/db.properties");

            if(input == null) {
                input = new FileInputStream((System.getProperty("user.dir") + "\\academy\\src\\main\\resources\\db.properties"));
            }

            prop.load(input);
            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("Errore: db.properties non trovato nel classpath e nel filesystem");
            throw new SQLException(e);

        } catch (IOException e) {
            System.out.println("Errore caricamento file di configurazione: " + e.getMessage());
            throw new SQLException(e);

        }

        String url = prop.getProperty("db.url");
        String user = prop.getProperty("db.user");
        String pass = prop.getProperty("db.password");

        if (url == null || user == null || pass == null) {
            throw new SQLException("Proprietà del database non trovate in db.properties");

        }

        return DriverManager.getConnection(url, user, pass);
    }
}
