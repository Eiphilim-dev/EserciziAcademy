package entity;

import java.time.LocalDate;

public class Studente {

    private String matricola;
    private String nome;
    private String cognome;
    private int eta;
    private LocalDate dataNasc;
    private String nomeCorso;
    private int esamiSostenuti;

    public Studente() {
    }

    public Studente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public Studente(String nome, String cognome, int eta, LocalDate dataNasc) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.dataNasc = dataNasc;
    }

    public Studente(String matricola, String nome, String cognome, int eta, LocalDate dataNasc, String nomeCorso, int esamiSostenuti) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.dataNasc = dataNasc;
        this.nomeCorso = nomeCorso;
        this.esamiSostenuti = esamiSostenuti;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getNomeCorso() {
        return nomeCorso;
    }

    public void setNomeCorso(String nomeCorso) {
        this.nomeCorso = nomeCorso;
    }

    public int getEsamiSostenuti() {
        return esamiSostenuti;
    }

    public void setEsamiSostenuti(int esamiSostenuti) {
        this.esamiSostenuti = esamiSostenuti;
    }
}
