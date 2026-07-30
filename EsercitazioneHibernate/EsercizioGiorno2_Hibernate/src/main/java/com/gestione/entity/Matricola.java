package com.gestione.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "matricola")
public class Matricola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer matricola_id;

    @Column(name = "codice_matricola", nullable = false, unique = true)
    private String codiceMatricola;

    @OneToOne(mappedBy = "matricola")
    @ToString.Exclude
    private Studente studente;

    public Matricola(String codiceMatricola) {
        this.codiceMatricola = codiceMatricola;
    }
}
