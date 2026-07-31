import entity.Studente;

import java.sql.*;
import java.time.LocalDate;


import static config.Connessione.getConnection;

public class MainApp {
    public static void main(String[] args) {

        Studente s1 = new Studente("102456", "Marco", "Rossi", 20,
                LocalDate.of(2006, 3, 15), "Informatica", 6);

        Studente s2 = new Studente("108921", "Sofia", "Bianchi", 22,
                LocalDate.of(2004, 7, 22), "Medicina e Chirurgia", 12);

        addStudente(s1);
        addStudente(s2);

        getStudente("102456");

        getAllStudente();

        s1.setEsamiSostenuti(12);
        s1.setNome("Mario");
        updateStudente(s1);

        updateStudenteByMatricola(s2,"108921");

        deleteStudente("102456");
        deleteAllStudente();

    }

    public static void addStudente(Studente studente) {
        String sql = "INSERT INTO studente VALUES (?, ?, ?, ?, ?, ?, ?)";

        try(Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, studente.getMatricola());
            ps.setString(2, studente.getNome());
            ps.setString(3, studente.getCognome());
            ps.setInt(4, studente.getEta());
            ps.setDate(5, java.sql.Date.valueOf(studente.getDataNasc()));
            ps.setString(6, studente.getNomeCorso());
            ps.setInt(7, studente.getEsamiSostenuti());

            int righeInserite = ps.executeUpdate();
            System.out.println("Righe inserite: " + righeInserite);

        } catch(SQLException e) {
            System.out.println("Errore INSERT: " +  e.getMessage());

        }
    }

    public static void getStudente(String matricola) {
        String sql = "SELECT * FROM studente WHERE matricola = ?";

        try(Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            try(ResultSet rs = ps.executeQuery()) {
                System.out.println("==== SCHEDA STUDENTE ====");

                while (rs.next()) {
                    matricola = rs.getString("matricola");
                    String  nome = rs.getString("nome");
                    String  cognome = rs.getString("cognome");
                    int eta = rs.getInt("eta");
                    Date dataNasc = rs.getDate("dataNasc");
                    String  nomeCorso = rs.getString("nomeCorso");
                    String esamiSostenuti = rs.getString("esamiSostenuti");

                    System.out.println("CodiceMatricola: " + matricola +
                                        ", Nome: " + nome +
                                        ", Cognome: " + cognome +
                                        ", Età: " + eta +
                                        ", Data di nascita: " + dataNasc +
                                        ", NomeCorso: " + nomeCorso +
                                        ", EsamiSostenuti: " + esamiSostenuti);

                }
            }
        } catch (SQLException e) {
            System.out.println("Errore SELECT:" +   e.getMessage());

        }
    }

    public static void getAllStudente() {
        String sql = "SELECT * FROM studente";

        try(Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            try(ResultSet rs = ps.executeQuery()) {
                System.out.println("==== LISTA STUDENTI ====");

                while (rs.next()) {
                    String  matricola = rs.getString("matricola");
                    String  nome = rs.getString("nome");
                    String  cognome = rs.getString("cognome");
                    int eta = rs.getInt("eta");
                    Date dataNasc = rs.getDate("dataNasc");
                    String  nomeCorso = rs.getString("nomeCorso");
                    String esamiSostenuti = rs.getString("esamiSostenuti");

                    System.out.println("CodiceMatricola: " + matricola +
                            ", Nome: " + nome +
                            ", Cognome: " + cognome +
                            ", Età: " + eta +
                            ", Data di nascita: " + dataNasc +
                            ", NomeCorso: " + nomeCorso +
                            ", EsamiSostenuti: " + esamiSostenuti);

                }
            }
        } catch (SQLException e) {
            System.out.println("Errore SELECT:" +   e.getMessage());

        }
    }

    public static void deleteStudente(String matricola) {
        String sql = "DELETE FROM studente WHERE matricola = ?";

        try(Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, matricola);

            int righeEliminate = ps.executeUpdate();
            System.out.println("Righe eliminate: " + righeEliminate);

        } catch (SQLException e) {
            System.out.println("Errore DELETE:" + e.getMessage());

        }
    }

    public static void deleteAllStudente() {
        String sql = "DELETE FROM studente";

        try(Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            int righeEliminate = ps.executeUpdate();
            System.out.println("Righe eliminate: " + righeEliminate);

        } catch (SQLException e) {
            System.out.println("Errore DELETE:" + e.getMessage());

        }
    }

    public static void updateStudente(Studente studente) {
        String sql = "UPDATE studente SET nome = ?, cognome = ?, eta = ?, data_nascita = ?, nome_corso = ?, esami_sostenuti = ?";

        try(Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, studente.getMatricola());
            ps.setString(2, studente.getNome());
            ps.setString(3, studente.getCognome());
            ps.setInt(4, studente.getEta());
            ps.setDate(5, java.sql.Date.valueOf(studente.getDataNasc()));
            ps.setString(6, studente.getNomeCorso());
            ps.setInt(7, studente.getEsamiSostenuti());

            int righeAggiornate = ps.executeUpdate();

            if (righeAggiornate > 0) {
                System.out.println("-> Studente aggiornato con successo!");

            } else {
                System.out.println("-> Nessun studente trovato.");

            }

        } catch (SQLException e) {
            System.out.println("Errore UPDATE: " + e.getMessage());

        }
    }

    public static void updateStudenteByMatricola(Studente studente,  String matricola) {
        String sql = "UPDATE studente SET nome = ?, esami_sostenuti = ? WHERE matricola = ?";

        try(Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, studente.getMatricola());
            ps.setString(2, studente.getNome());
            ps.setString(3, studente.getCognome());
            ps.setInt(4, studente.getEta());
            ps.setDate(5, java.sql.Date.valueOf(studente.getDataNasc()));
            ps.setString(6, studente.getNomeCorso());
            ps.setInt(7, studente.getEsamiSostenuti());

            int righeAggiornate = ps.executeUpdate();

            if (righeAggiornate > 0) {
                System.out.println("-> Studente aggiornato con successo!");

            } else {
                System.out.println("-> Nessun studente trovato con matricola: " + matricola);

            }

        } catch (SQLException e) {
            System.out.println("Errore UPDATE: " + e.getMessage());

        }
    }
}
