package com.gestione.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "studente")
public class Studente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer studente_id;

    @Column(name = "nome", nullable = false, length = 20)
    private String nome;

    @Column(name = "cognome", nullable = false, length = 20)
    private String cognome;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "matricola_id", unique = true)
    private Matricola matricola;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "studente_corso",
            joinColumns = @JoinColumn(name = "studente_id"),
            inverseJoinColumns = @JoinColumn(name = "corso_id")
    )
    @ToString.Exclude
    private List<Corso> corsi = new ArrayList<>();

    public Studente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public void addCorso(Corso corso) {
        this.corsi.add(corso);
        corso.getStudenti().add(this);
    }
}
