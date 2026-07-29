package EserciziGiorno15;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class MainCRUD_Gatto {
    static void main(String[] args) {
        aggiungiGatto("Micio", 3, "Nero");
        stampaGatti();
        aggiornaByName("Fuffi", 1);
        cancellaGatto(1);
        cancellaAll();
    }

    public static void aggiungiGatto(String nome, int eta, String colorePelo) {

        String sql = "INSERT INTO gatto (nome, eta, colore_pelo) VALUES (?, ?, ?)";

        try(Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nome);
            ps.setInt(2, eta);
            ps.setString(3, colorePelo);

            int righeInserite = ps.executeUpdate();
            System.out.println("Righe inserite: " + righeInserite);

        } catch(SQLException e) {
            System.out.println("Errore INSERT: " +  e.getMessage());

        }
    }

    public static void stampaGatti() {

        String sql = "SELECT * FROM gatto";

        try(Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int microchip = rs.getInt("microchip");
                    String nome = rs.getString("nome");
                    int eta = rs.getInt("eta");
                    String colorePelo = rs.getString("colore_pelo");

                    System.out.println("MicroChip: " + microchip + ", Nome: " + nome + ", Età: " + eta + ", Colore pelo: " + colorePelo);

                }
            }
        } catch (SQLException e) {
            System.out.println("Errore SELECT:" +   e.getMessage());

        }
    }

    public static void cancellaGatto(int microchip) {
        String sql = "DELETE FROM gatto WHERE microchip = ?";

        try(Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, microchip);

            int righeEliminate = ps.executeUpdate();
            System.out.println("Righe eliminate: " + righeEliminate);

        } catch (SQLException e) {
            System.out.println("Errore DELETE:" + e.getMessage());

        }
    }

    public static void cancellaAll() {
        String sql = "DELETE FROM gatto";

        try(Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            int righeEliminate = ps.executeUpdate();
            System.out.println("Righe eliminate: " + righeEliminate);

        } catch (SQLException e) {
            System.out.println("Errore DELETE:" + e.getMessage());

        }
    }

    public static void aggiornaByName(String nome, int microchip) {
        String sql = "UPDATE gatto SET nome = ? WHERE microchip = ?";

        try(Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nome);
            ps.setInt(2, microchip);

            int righeAggiornate = ps.executeUpdate();
            System.out.println("Righe aggiornate: " + righeAggiornate);

        } catch (SQLException e) {
            System.out.println("Errore UPDATE:" + e.getMessage());

        }
    }

    private static Connection getConnection() throws SQLException{

        Properties prop = new Properties();
        InputStream input;

        try {

            input = MainCRUD_Gatto.class.getResourceAsStream("/db.properties");

            if(input == null) {
                input = new FileInputStream((System.getProperty("user.dir") + "\\academy\\src\\main\\resources\\db.properties"));
            }
            
            prop.load(input);
            input.close();

        } catch (java.io.FileNotFoundException e) {
            System.out.println("Errore: db.properties non trovato nel classpath e nel filesystem");
            throw new SQLException(e);
        } catch (IOException e) {
            System.out.println("Errore caricamento file di configurazione: " + e.getMessage());
            throw new SQLException(e);
        }

        String url = prop.getProperty("db.url");
        String user = prop.getProperty("db.username");
        String pass = prop.getProperty("db.password");
        
        if(url == null || user == null || pass == null) {
            throw new SQLException("Proprietà del database non trovate in db.properties");
        }

        return DriverManager.getConnection(url, user, pass);
    }
}
