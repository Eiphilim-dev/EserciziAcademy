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
@Table(name = "corso")
public class Corso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer corso_id;

    @Column(name = "descrizione", length = 300)
    private String descrizione;

    @Column(name = "denominazione", length = 90)
    private String denominazione;

    @ManyToMany(mappedBy = "corsi")
    @ToString.Exclude
    private List<Studente> studenti = new ArrayList<>();

    public Corso(String descrizione, String denominazione) {
        this.descrizione = descrizione;
        this.denominazione = denominazione;

    }
}
